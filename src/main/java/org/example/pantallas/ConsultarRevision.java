package org.example.pantallas;

import org.example.gestores.GestorRevision;
import org.example.modelos.Revision;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultarRevision extends JFrame {
    private JPanel panelPrincipal;
    private GestorRevision gestorRevision;
    private JTextField TFNumDoc;
    private JLabel LNumDoc;
    private JTextField TFNumPatente;
    private JLabel LPatente;
    private JLabel LRevisiones;
    private JComboBox<Revision> CBRevisiones;  // Cambiado a JComboBox<Revision>
    private JButton BBuscar;
    private JTextField TFRevision;
    private JTextField TFDoc;
    private JTextField TFPatente;
    private JTextField TFFechaAlta;
    private JTextField TFEstacionVTV;
    private JLabel LRevision;
    private JLabel LDoc;
    private JLabel LNumPatente;
    private JLabel LFechaAlta;
    private JLabel LEstacionVTV;
    private JLabel FIntroduccion;

    public ConsultarRevision(GestorRevision gestorRevision) {
        this.gestorRevision = gestorRevision;
        setContentPane(panelPrincipal);

        setTitle("Consultar Revisión");  // Configurar el título de la ventana
        setSize(520, 500); // Configurar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definir el comportamiento de cierre
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true); // Mostrar la ventana

        BBuscar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    String rPatente = TFNumPatente.getText().isEmpty() ? null : TFNumPatente.getText().toUpperCase();
                    String rCliente = TFNumDoc.getText().isEmpty() ? null : TFNumDoc.getText().toUpperCase();

                    // Mensajes de depuración para verificar campos vacíos
                    if (rPatente == null && rCliente == null) {
                        throw new IllegalArgumentException("Ambos campos están vacíos.");
                    }

                    if (rPatente != null && gestorRevision.getGestorVehiculo().buscar(rPatente) == null) {
                        throw new IllegalArgumentException("No existe un vehículo registrado con esa patente.");
                    }
                    if (rCliente != null && gestorRevision.getGestorCliente().buscar(rCliente) == null) {
                        throw new IllegalArgumentException("No existe un cliente registrado con ese N° de documento.");
                    }

                    CBRevisiones.removeAllItems();  // Limpia el JComboBox antes de agregar elementos

                    // Buscar revisiones por cliente y/o vehículo
                    if (rCliente != null && rPatente != null){
                        for (Revision revision : gestorRevision.buscarRevisionesClienteYVehiculo(rCliente, rPatente)) {
                            CBRevisiones.addItem(revision);
                        }
                    } else if (rPatente == null) {
                        for (Revision revision : gestorRevision.buscarRevisionesCliente(rCliente)) {
                            CBRevisiones.addItem(revision);
                        }
                    } else if (rCliente == null) {
                        for (Revision revision : gestorRevision.buscarRevisionesVehiculo(rPatente)) {
                            CBRevisiones.addItem(revision);
                        }
                    }

                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(panelPrincipal, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        CBRevisiones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Revision r = (Revision) CBRevisiones.getSelectedItem();
                if (r != null) {
                    // Realizar alguna acción con la revisión seleccionada
                    System.out.println("Revisión seleccionada: " + r);
                    // Aquí puedes añadir el código para realizar la acción deseada
                    TFRevision.setText(String.valueOf(r.getNroRevision()));
                    TFDoc.setText(r.getCliente().getNroDocumento());
                    TFPatente.setText(r.getVehiculo().getPatente());
                    TFFechaAlta.setText(String.valueOf(r.getFechaAlta()));
                    TFEstacionVTV.setText(r.getEstacion().toString());
                }
            }
        });
    }
}


