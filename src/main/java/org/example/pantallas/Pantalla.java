package org.example.pantallas;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public abstract class Pantalla extends JFrame {

    public void vaciarCampos(Container panel) {
        Arrays.stream(panel.getComponents())
                .filter(component -> component instanceof JTextField)
                .forEach(component -> ((JTextField) component).setText(""));

    }

    public void colorearPantalla(Container panel) {
        for (Component componente : panel.getComponents()) {
            if (componente instanceof JButton) {
                componente.setBackground(Color.ORANGE);
            }
        }
    }
}
