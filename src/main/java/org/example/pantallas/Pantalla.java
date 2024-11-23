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

    public void colorearBotones(Container panel) {

        Arrays.stream(panel.getComponents())
                .filter(component -> component instanceof JButton || component instanceof JComboBox)
                .forEach(component ->  {
                    if (component instanceof JButton) {
                        component.setBackground(new Color(255,167,38));
                    } else {
                        component.setBackground(Color.lightGray);
                    }
                });
    }

}
