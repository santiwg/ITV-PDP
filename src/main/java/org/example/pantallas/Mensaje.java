package org.example.pantallas;

import javax.swing.*;

public class Mensaje extends JFrame {
    private JLabel mensaje;
    private JPanel panelPrincipal;

    public Mensaje(String mensaje){
        setContentPane(panelPrincipal); //este linea va si o si, sino no podemos trabajar con el panel armado

        setTitle("Mensaje");  //configurar el título de la ventana
        setSize(300,80); //configurar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //define el comportamiento de cierre (lo que hace cuando se toca la cruz)
        setLocationRelativeTo(null); //indicamos respecto a que se centre, al poner null es respecto al centro.
        setVisible(true); //esto es lo más importante, sin esto no va a abrir la ventana
        this.mensaje.setText(mensaje);
    }

    public Mensaje() {

    }
    /*public static void main (String[] args){
        new Mensaje("MENSAJE DE PRUEBA JJABBJBSJBSJBDIHJKJKJKJKJKJKJKJKNJBBBIBYVTVTUVUVIVYVIYUVUVUVUVYV");
    }*/

}
