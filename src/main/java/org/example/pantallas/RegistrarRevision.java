package org.example.pantallas;

import org.example.gestores.GestorRevision;
import org.example.modelos.EstacionVTV;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class RegistrarRevision extends JFrame {
    private JPanel panelPrincipal;
    private JTextField caPatente;
    private JLabel etPatente;
    private JLabel etEstacion;
    private JComboBox listaEstaciones;
    private JLabel etCliente;
    private JTextField caCliente;
    private JButton registrar;
    public GestorRevision gestorRevision;

    public RegistrarRevision(GestorRevision gestorRevision) {
        this.gestorRevision =  gestorRevision;
        setContentPane(panelPrincipal);

        setTitle("Registrar revisión");
        setSize(520,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        DefaultComboBoxModel <EstacionVTV> estaciones = new DefaultComboBoxModel<>();
        for (EstacionVTV estacion: gestorRevision.getGestorEstacionVTV().getListaEstaciones()) {
            estaciones.addElement(estacion);
        }
        listaEstaciones.setModel(estaciones);


        registrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    String rPatente = caPatente.getText().isEmpty() ? null : caPatente.getText().toUpperCase();
                    String rCliente = caCliente.getText().isEmpty() ? null : caCliente.getText().toUpperCase();
                    EstacionVTV rEstacion = listaEstaciones.getSelectedItem() == null ? null : (EstacionVTV) listaEstaciones.getSelectedItem();

                    if (rPatente == null || rCliente == null || rEstacion == null) {
                        throw new IllegalArgumentException("Hay campos vacíos.");
                    }
                    if (gestorRevision.getGestorVehiculo().buscar(rPatente)==null) {
                        throw new IllegalArgumentException("No existe un vehículo registrado con esa patente.");
                    }
                    if (gestorRevision.getGestorCliente().buscar(rCliente)==null) {
                        throw new IllegalArgumentException("No existe un cliente registrado con ese N° de documento.");
                    }

                    gestorRevision.agregarRevision(gestorRevision.getNumeroRevision(),gestorRevision.getGestorCliente().buscar(rCliente),
                            gestorRevision.getGestorVehiculo().buscar(rPatente), rEstacion, LocalDate.now());
                    new Mensaje("Revisión registrada.");
                } catch (NumberFormatException error) {
                    new Mensaje("Error al intentar registrar la revisión: \n Puede que haya ingresado caracteres en lugar de números.");
                } catch (IllegalArgumentException error) {
                    new Mensaje("Error al intentar registrar el vehículo: \n"+error.getMessage());
                } catch (Exception error) {
                    new Mensaje("Error al intentar registrar la revisión");
                }
            }
        });
    }
}
