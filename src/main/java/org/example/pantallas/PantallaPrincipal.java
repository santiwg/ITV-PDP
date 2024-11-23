package org.example.pantallas;

import org.example.gestores.GestorCliente;
import org.example.gestores.GestorRevision;
import org.example.gestores.GestorVehiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaPrincipal extends Pantalla {
    private JPanel panelPrincipal;
    private JButton botConsVe;
    private JButton botRegCl;
    private JButton botConsRev;
    private JButton botRegRev;
    private JButton botRegVe;
    private JButton botConsCl;
    private JLabel etLogo;
    private GestorVehiculo gVehiculo;
    private GestorCliente gCliente;
    private GestorRevision gRevision;


    public PantallaPrincipal(GestorVehiculo gVehiculo, GestorCliente gCliente, GestorRevision gRevision) {
        this.gVehiculo = gVehiculo;
        this.gCliente=gCliente;
        this.gRevision=gRevision;
        setContentPane(panelPrincipal); //este linea va si o si, sino no podemos trabajar con el panel armado
        setTitle("Applus+");  //configurar el título de la ventana
        setSize(600,600); //configurar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //define el comportamiento de cierre (lo que hace cuando se toca la cruz)
        setLocationRelativeTo(null); //indicamos respecto a que se centre, al poner null es respecto al centro.
        setVisible(true); //esto es lo más importante, sin esto no va a abrir la ventana
        colorearBotones(panelPrincipal);

        // Cargar la imagen del ícono
        ImageIcon originalIcon = new ImageIcon(getClass().getClassLoader().getResource("images/applus-icono-ventana.png"));
        // Redimensionar la imagen al tamaño deseado (ejemplo: 32x32)
        Image scaledIcon = originalIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        // Establecer el ícono redimensionado
        setIconImage(scaledIcon);

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
        botRegRev.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new RegistrarRevision(gRevision);
            }
        });
        botConsRev.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new ConsultarRevision(gRevision);
            }
        });
    }
}
