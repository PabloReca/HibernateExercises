package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class FormularioProductosView {
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

    public FormularioProductosView() {
        setUpPlaceholders(campos);

        panelPrincipal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelPrincipal.requestFocusInWindow();
            }
        });

        title.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    public JPanel getPanel() {
        return panelPrincipal;
    }

    public JTextField getNombreDelProducto() {
        return nombreDelProducto;
    }

    public JTextField getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public JTextField getIdCategoria() {
        return idCategoria;
    }

    public JTextField getIdProvedor() {
        return idProvedor;
    }

    public JTextField getUnidadesStock() {
        return unidadesStock;
    }

    public JTextField getUnidadesPedido() {
        return unidadesPedido;
    }

    public JTextField getNivelReordenamiento() {
        return nivelReordenamiento;
    }

    public JTextField getEstadoDiscontinuacion() {
        return estadoDiscontinuacion;
    }

    public JTextField getCantidadPorUnidad() {
        return cantidadPorUnidad;
    }

    public JButton getEnviarButton() {
        return enviarButton;
    }

    public JLabel getMensaje() {
        return mensaje;
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
}
