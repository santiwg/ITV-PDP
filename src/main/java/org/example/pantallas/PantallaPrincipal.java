package org.example.pantallas;

import org.example.gestores.GestorCliente;
import org.example.gestores.GestorVehiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaPrincipal extends JFrame {
    private JPanel panelPrincipal;
    private JButton botConsVe;
    private JButton botRegCl;
    private JButton botConsRev;
    private JButton botRegRev;
    private JButton botRegVe;
    private JButton botConsCl;
    private GestorVehiculo gVehiculo;
    private GestorCliente gCliente;



    public PantallaPrincipal(GestorVehiculo gVehiculo, GestorCliente gCliente) throws HeadlessException {
        this.gVehiculo = gVehiculo;
        this.gCliente=gCliente;
        setContentPane(panelPrincipal); //este linea va si o si, sino no podemos trabajar con el panel armado
        setTitle("Pantalla Principal");  //configurar el título de la ventana
        setSize(420,500); //configurar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //define el comportamiento de cierre (lo que hace cuando se toca la cruz)
        setLocationRelativeTo(null); //indicamos respecto a que se centre, al poner null es respecto al centro.
        setVisible(true); //esto es lo más importante, sin esto no va a abrir la ventana
        botRegVe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new RegistrarVehiculo(gVehiculo);
            }
        });
        botConsVe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new ConsultarVehiculo(gVehiculo);
            }
        });

        botConsCl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new ConsultarCliente(gCliente);
            }
        });
        botRegCl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new RegistrarCliente(gCliente);
            }
        });
    }



      /*public static void main(String[] args){
        new PantallaPrincipal(); //no lo guardo en ninguna variable, cuando se ejecuta el main me crea el objeto que es la UI
    }*/
}
