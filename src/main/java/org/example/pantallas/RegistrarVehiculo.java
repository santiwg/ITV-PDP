package org.example.pantallas;

import org.example.gestores.GestorVehiculo;
import org.example.modelos.TipoVehiculo;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrarVehiculo extends JFrame {
    private JPanel panelPrincipal;
    private JLabel etNroChasis;
    private JTextField caNroChasis;
    private JTextField caModelo;
    private JTextField caAnioFabricacion;
    private JLabel etMarca;
    private JLabel etModelo;
    private JTextField caKilometros;
    private JTextField caTipo;
    private JLabel etAnioFabricacion;
    private JLabel etKilometros;
    private JTextField caMarca;
    private JLabel etTipo;
    private JTextField caCombustible;
    private JTextField caPatente;
    private JLabel etPatente;
    private JButton registrar;
    private JLabel etCombustible;
    private JTextField caEjes;
    private JLabel etEjes;
    private JList listaTipos;
    private JLabel etSeleccioTipo;
    private GestorVehiculo gestorVehiculo;



    public RegistrarVehiculo(GestorVehiculo gestorVehiculo){
        this.gestorVehiculo=gestorVehiculo;
        setContentPane(panelPrincipal); //este linea va si o si, sino no podemos trabajar con el panel armado

        setTitle("Registrar Vehiculo");  //configurar el título de la ventana
        setSize(400,400); //configurar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //define el comportamiento de cierre (lo que hace cuando se toca la cruz)
        setLocationRelativeTo(null); //indicamos respecto a que se centre, al poner null es respecto al centro.
        setVisible(true); //esto es lo más importante, sin esto no va a abrir la ventana


        DefaultListModel <TipoVehiculo> tipos=new DefaultListModel<>();
        for (TipoVehiculo t:gestorVehiculo.getGestorTV().getListaTiposVehiculo()){
            tipos.addElement(t);
        }
        listaTipos.setModel(tipos); //set model es cuando le paso una estructura

        listaTipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                caTipo.setText(listaTipos.getSelectedValue().toString());
            }
        });
        registrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {

                    //que se realice la asignación de null o el contenido de la entrada según si está vacía o no


                    int anioFabricacion=Integer.parseInt(caAnioFabricacion.getText());
                    double kilometros=Double.parseDouble(caKilometros.getText());
                    int cantEjes=Integer.parseInt(caEjes.getText());
                    String patente = caPatente.getText().isEmpty() ? null : caPatente.getText().toUpperCase();
                    String nroChasis = caNroChasis.getText().isEmpty() ? null : caNroChasis.getText().toUpperCase();
                    String marca = caMarca.getText().isEmpty() ? null : caMarca.getText().toUpperCase();
                    String modelo = caModelo.getText().isEmpty() ? null : caModelo.getText().toUpperCase();
                    TipoVehiculo tipo = listaTipos.getSelectedValue() == null ? null : (TipoVehiculo) listaTipos.getSelectedValue(); // uso casteo
                    String tipoCombustible = caCombustible.getText().isEmpty() ? null : caCombustible.getText().toUpperCase();

                    if (patente == null || nroChasis == null || marca == null || modelo == null || tipoCombustible == null || tipo == null) {
                        throw new IllegalArgumentException("Hay campos vacíos.");
                    }
                    if (gestorVehiculo.buscar(patente)!=null){
                        throw new IllegalArgumentException("Ya existe un vehículo con esa patente.");
                    }


                    gestorVehiculo.agregar(tipo,tipoCombustible,patente,nroChasis,modelo,marca,
                            kilometros,anioFabricacion,cantEjes);
                    new Mensaje("Vehiculo Registrado");
                } catch (NumberFormatException error) {
                    new Mensaje("Error al intentar registrar el vehículo:\nPuede que haya ingresado caracteres en lugar de números.");
                } catch (IllegalArgumentException error) {
                    new Mensaje("Error al intentar registrar el vehículo:\n"+error.getMessage());
                } catch (Exception error) {
                    new Mensaje("Error al intentar registrar el vehículo");
                }
            }
        });

    }
    /*public static void main(String[] args){
        new RegistrarVehiculo(); //no lo guardo en ninguna variable, cuando se ejecuta el main me crea el objeto que es la UI
    }*/
}