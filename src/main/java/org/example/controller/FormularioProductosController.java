package org.example.controller;

import org.example.model.ProductsEntity;
import org.example.view.FormularioProductosView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioProductosController {
    private final FormularioProductosView view;
    private final SessionFactory sessionFactory;

    public FormularioProductosController(FormularioProductosView view) {
        this.view = view;
        this.view.getEnviarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
    }

    private void guardarProducto() {
        try {
            String productName = view.getNombreDelProducto().getText();
            int supplierId = Integer.parseInt(view.getIdProvedor().getText());
            int categoryId = Integer.parseInt(view.getIdCategoria().getText());
            String quantityPerUnit = view.getCantidadPorUnidad().getText();
            double unitPrice = Double.parseDouble(view.getPrecioPorUnidad().getText());
            short unitsInStock = Short.parseShort(view.getUnidadesStock().getText());
            short unitsOnOrder = Short.parseShort(view.getUnidadesPedido().getText());
            short reorderLevel = Short.parseShort(view.getNivelReordenamiento().getText());
            byte discontinued = Byte.parseByte(view.getEstadoDiscontinuacion().getText());

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

            view.getMensaje().setText("Producto creado exitosamente.");
        } catch (NumberFormatException ex) {
            view.getMensaje().setText("Error en la entrada de datos numéricos.");
            ex.printStackTrace();
        } catch (Exception ex) {
            view.getMensaje().setText("Error al crear el producto.");
            ex.printStackTrace();
        }
    }
}
