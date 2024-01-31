package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import entity.ProductsEntity;

public class FormularioProductos {

    private JPanel panelPrincipal;
    private JTextField nombreDelProducto;
    private JTextField precioPorUnidad;
    private JTextField idCategoria;
    private JTextField idProvedor;
    private JTextField unidadesStock;
    private JTextField unidadesPedido;
    private JTextField nivelReordenamiento;
    private JTextField estadoDiscontinuacion;
    private JTextField cantidadPorUnidad;
    private JPanel campos;
    private JButton enviarButton;
    private JLabel mensaje;
    private JLabel title;
    private final SessionFactory sessionFactory;

    public FormularioProductos() {
        setUpPlaceholders(campos);

        panelPrincipal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelPrincipal.requestFocusInWindow();
            }
        });

        title.setFont(new Font("Arial", Font.PLAIN, 20));

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();

        enviarButton.addActionListener(e -> guardarProducto());
    }

    private void guardarProducto() {
        try {
            String productName = nombreDelProducto.getText();
            int supplierId = Integer.parseInt(idProvedor.getText());
            int categoryId = Integer.parseInt(idCategoria.getText());
            String quantityPerUnit = cantidadPorUnidad.getText();
            double unitPrice = Double.parseDouble(precioPorUnidad.getText());
            short unitsInStock = Short.parseShort(unidadesStock.getText());
            short unitsOnOrder = Short.parseShort(unidadesPedido.getText());
            short reorderLevel = Short.parseShort(nivelReordenamiento.getText());
            byte discontinued = Byte.parseByte(estadoDiscontinuacion.getText());

            ProductsEntity product = new ProductsEntity();
            product.setProductName(productName);
            product.setSupplierId(supplierId);
            product.setCategoryId(categoryId);
            product.setQuantityPerUnit(quantityPerUnit);
            product.setUnitPrice(unitPrice);
            product.setUnitsInStock(unitsInStock);
            product.setUnitsOnOrder(unitsOnOrder);
            product.setReorderLevel(reorderLevel);
            product.setDiscontinued(discontinued);

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            session.close();

            mensaje.setText("Producto creado exitosamente.");
        } catch (NumberFormatException ex) {
            mensaje.setText("Error en la entrada de datos numéricos.");
            ex.printStackTrace();
        } catch (Exception ex) {
            mensaje.setText("Error al crear el producto.");
            ex.printStackTrace();
        }
    }

    private void setUpPlaceholders(JPanel panel) {
        Arrays.stream(panel.getComponents())
                .forEach(component -> {
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                        String placeholderText = textField.getText();
                        textField.setForeground(Color.GRAY);
                        textField.addFocusListener(new FocusAdapter() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (textField.getText().equals(placeholderText)) {
                                    textField.setText("");
                                    textField.setForeground(Color.BLACK);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (textField.getText().isEmpty()) {
                                    textField.setText(placeholderText);
                                    textField.setForeground(Color.GRAY);
                                }
                            }
                        });
                    } else if (component instanceof JPanel) {
                        setUpPlaceholders((JPanel) component);
                    }
                });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario Productos");
        frame.setContentPane(new FormularioProductos().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(640, 480));
        frame.setLocationRelativeTo(null);
        frame.requestFocusInWindow();
    }
}
