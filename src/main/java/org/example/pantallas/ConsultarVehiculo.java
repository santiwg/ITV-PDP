package org.example.pantallas;

import org.example.gestores.GestorVehiculo;
import org.example.modelos.Vehiculo;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;

public class ConsultarVehiculo extends Pantalla{
    private JTextField caNroChasis;
    private JTextField caModelo;
    private JTextField caAnioFabricacion;
    private JTextField caKilometros;
    private JTextField caTipo;
    private JTextField caMarca;
    private JTextField caCombustible;
    private JTextField caPatente;
    private JButton buscar;
    private JLabel etPatente;
    private JLabel etNroChasis;
    private JLabel etMarca;
    private JLabel etModelo;
    private JLabel etAnioFabricacion;
    private JLabel etKilometros;
    private JLabel etTipo;
    private JTextField caEjes;
    private JLabel etCombustible;
    private JLabel etEjes;
    private JPanel panelPrincipal;
    private GestorVehiculo gVehiculo;


    public ConsultarVehiculo(GestorVehiculo gVehiculo){
        this.gVehiculo=gVehiculo;
        setContentPane(panelPrincipal); //este linea va si o si, sino no podemos trabajar con el panel armado

        setTitle("Consultar Vehiculo");  //configurar el título de la ventana
        setSize(400,400); //configurar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //define el comportamiento de cierre (lo que hace cuando se toca la cruz)
        setLocationRelativeTo(null); //indicamos respecto a que se centre, al poner null es respecto al centro.
        colorearBotones(panelPrincipal);
        setVisible(true); //esto es lo más importante, sin esto no va a abrir la ventana

        // Cambiar el ícono de la ventana
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("images/consultar-vehiculo.png"));
        setIconImage(icon);

        buscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    if (gVehiculo.buscar(caPatente.getText().toUpperCase())==null){
                        throw new IllegalArgumentException("No se ha registrado un vehículo con esa patente. ");
                    }


                    Vehiculo v=gVehiculo.buscar(caPatente.getText().toUpperCase());
                    caNroChasis.setText(v.getNroChasis());
                    caEjes.setText(String.valueOf(v.getCantidadEjes()));
                    caTipo.setText(v.getTipovehiculo().toString());
                    caCombustible.setText(v.getTipoCombustible());
                    caKilometros.setText(String.valueOf(v.getKilometros()));
                    caAnioFabricacion.setText(String.valueOf(v.getAnioFabricacion()));
                    caMarca.setText(v.getMarca());
                    caModelo.setText(v.getModelo());

                } catch (IllegalArgumentException error) {
                    JOptionPane.showMessageDialog(null,"Error al buscar el vehículo: \n "+error.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null,"Error al buscar el vehículo "+error.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }

}
