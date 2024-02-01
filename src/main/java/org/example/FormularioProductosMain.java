package org.example;

import javax.swing.*;
import java.awt.*;

public class FormularioProductosMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario Productos");
        FormularioProductosView view = new FormularioProductosView();
        FormularioProductosController controller = new FormularioProductosController(view);

        frame.setContentPane(view.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(640, 480));
        frame.setLocationRelativeTo(null);
        frame.requestFocusInWindow();
    }
}
