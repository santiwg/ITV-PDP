package org.example.pantallas;

import org.example.gestores.GestorCliente;
import org.example.modelos.Cliente;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultarCliente extends Pantalla{
    private GestorCliente gCliente;
    private JPanel panelPrincipal;
    private JLabel etNumDNI;
    private JTextField caNumDni;
    private JButton buscar;
    private JLabel etNombre;
    private JTextField caNombre;
    private JLabel etApellido;
    private JTextField caApellido;
    private JLabel etFechaNacimiento;
    private JTextField caFechaNacimiento;
    private JLabel etEdad;
    private JTextField caEdad;
    private JLabel etCorreo;
    private JTextField caCorreo;
    private JLabel etDomicilio;
    private JTextField caDomicilio;
    private JLabel etTelefono;
    private JTextField caTelefono;
    private JLabel etTipoDNI;
    private JTextField caTipoDoc;


    public ConsultarCliente(GestorCliente gCliente){
        this.gCliente = gCliente;
        setContentPane(panelPrincipal); //este linea va si o si, sino no podemos trabajar con el panel armado

        setTitle("Consultar Cliente");  //configurar el título de la ventana
        setSize(400,400); //configurar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //define el comportamiento de cierre (lo que hace cuando se toca la cruz)
        setLocationRelativeTo(null); //indicamos respecto a que se centre, al poner null es respecto al centro.
        setVisible(true); //esto es lo más importante, sin esto no va a abrir la ventana

        buscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    if (gCliente.buscar(caNumDni.getText().toUpperCase())==null){
                        throw new IllegalArgumentException("No se ha encontrado el cliente.");
                    }

                    /*COMPLETAR*/
                    Cliente c = gCliente.buscar(caNumDni.getText().toUpperCase());
                    caNumDni.setText(c.getNroDocumento());
                    caNombre.setText(String.valueOf(c.getNombre()));
                    caApellido.setText(c.getApellido());
                    caFechaNacimiento.setText(c.getFechaNacimiento().getDayOfMonth() + "/" + c.getFechaNacimiento().getMonthValue() + "/" + c.getFechaNacimiento().getYear()); // LEER DATE
                    caEdad.setText((c.calcularEdad())+ " años");
                    caCorreo.setText(c.getCorreo());
                    caDomicilio.setText(c.getDomicilio());
                    caTelefono.setText((c.getNroTelefono()));
                    caTipoDoc.setText(c.getTipoDocumento());

                } catch (IllegalArgumentException error) {
                    new Mensaje("Error al buscar el cliente:\n"+error.getMessage());
                } catch (Exception error) {
                    new Mensaje("Error al buscar el cliente"+error.getMessage());
                }
            }

        });
    }
}
