package org.example.pantallas;

import org.example.gestores.GestorVehiculo;
import org.example.modelos.TipoVehiculo;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrarVehiculo extends Pantalla {
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
    private JTextField caCombustible;
    private JTextField caPatente;
    private JLabel etPatente;
    private JButton registrar;
    private JLabel etCombustible;
    private JTextField caEjes;
    private JLabel etEjes;
    private JLabel etSeleccioTipo;
    private JComboBox<TipoVehiculo> comboTipos;
    private JButton limpiarCamposButton;
    private GestorVehiculo gestorVehiculo;



    public RegistrarVehiculo(GestorVehiculo gestorVehiculo){
        this.gestorVehiculo=gestorVehiculo;
        setContentPane(panelPrincipal); //este linea va si o si, sino no podemos trabajar con el panel armado

        setTitle("Registrar Vehiculo");  //configurar el título de la ventana
        setSize(520,500); //configurar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //define el comportamiento de cierre (lo que hace cuando se toca la cruz)
        setLocationRelativeTo(null); //indicamos respecto a que se centre, al poner null es respecto al centro.
        colorearBotones(panelPrincipal);
        setVisible(true); //esto es lo más importante, sin esto no va a abrir la ventana




        DefaultComboBoxModel<TipoVehiculo> tipos = new DefaultComboBoxModel<>();
        gestorVehiculo.getGestorTV().getListaTiposVehiculo().stream().forEach(t->tipos.addElement(t));
        /*for (TipoVehiculo t : gestorVehiculo.getGestorTV().getListaTiposVehiculo()) {
            tipos.addElement(t);
        }*/
        comboTipos.setModel(tipos);
        comboTipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

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
                    TipoVehiculo tipo = comboTipos.getSelectedItem() == null ? null : (TipoVehiculo) comboTipos.getSelectedItem(); // uso casteo
                    String tipoCombustible = caCombustible.getText().isEmpty() ? null : caCombustible.getText().toUpperCase();

                    if (patente == null || nroChasis == null || marca == null || modelo == null || tipoCombustible == null || tipo == null) {
                        throw new IllegalArgumentException("Hay campos vacíos.");
                    }
                    if (gestorVehiculo.buscar(patente)!=null){
                        throw new IllegalArgumentException("Ya existe un vehículo con esa patente.");
                    }


                    gestorVehiculo.agregar(tipo,tipoCombustible,patente,nroChasis,modelo,marca,
                            kilometros,anioFabricacion,cantEjes);
                    JOptionPane.showMessageDialog(null,"Vehiculo Registrado","",JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null,"Error al intentar registrar el vehículo: \n Puede que haya ingresado caracteres en lugar de números.","Error",JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException error) {
                    JOptionPane.showMessageDialog(null,"Error al intentar registrar el vehículo: \n"+error.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null,"Error al intentar registrar el vehículo","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        limpiarCamposButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                vaciarCampos(panelPrincipal);
            }
        });
    }
}
