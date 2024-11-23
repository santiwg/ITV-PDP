package org.example.pantallas;

import org.example.gestores.GestorCliente;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.DateTimeException;
import java.time.LocalDate;

public class RegistrarCliente extends Pantalla {
    private JPanel panelPrincipal;
    private JTextField caApellido;
    private JTextField caNombre;
    private JTextField caFechaNacimiento;
    private JTextField caCorreo;
    private JTextField caDomicilio;
    private JTextField caNroTelefono;
    private JTextField caTipoDocumento;
    private JTextField caNroDocumento;
    private JButton registrar;
    private JLabel etNombre;
    private JLabel etNroDocumento;
    private JLabel etTipoDocumento;
    private JLabel etNroTelefono;
    private JLabel etDomicilio;
    private JLabel etCorreo;
    private JLabel etFechaNacimiento;
    private JLabel etApellido;
    private JButton limpiarCamposButton;
    private GestorCliente gestorCliente;

    public RegistrarCliente(GestorCliente gestorCliente){
        this.gestorCliente=gestorCliente;
        setContentPane(panelPrincipal); //este linea va si o si, sino no podemos trabajar con el panel armado

        setTitle("Registrar Cliente");  //configurar el título de la ventana
        setSize(520,500); //configurar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //define el comportamiento de cierre (lo que hace cuando se toca la cruz)
        setLocationRelativeTo(null); //indicamos respecto a que se centre, al poner null es respecto al centro.
        colorearBotones(panelPrincipal);
        setVisible(true); //esto es lo más importante, sin esto no va a abrir la ventana

        // Cambiar el ícono de la ventana
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("images/registrar-cliente.png"));
        setIconImage(icon);

        registrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {


                    String nombre = caNombre.getText().isEmpty() ? null : caNombre.getText().toUpperCase();
                    String apellido = caApellido.getText().isEmpty() ? null : caApellido.getText().toUpperCase();
                    String[] fechaNacimientoArray = caFechaNacimiento.getText().trim().split("/"); // "Formato dd/MM/yyyy"
                    if (fechaNacimientoArray.length != 3) {
                        throw new IllegalArgumentException("Formato de fecha incorrecto. El formato correcto es dd/mm/aaaa.");
                    }
                    int diaNacimiento = Integer.parseInt(fechaNacimientoArray[0]);
                    int mesNacimiento = Integer.parseInt(fechaNacimientoArray[1]);
                    int anioNacimiento = Integer.parseInt(fechaNacimientoArray[2]);
                    LocalDate fechaNacimiento;
                    try {
                        if (anioNacimiento <= LocalDate.now().getYear()) {
                            fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
                        }
                        else {
                            throw new IllegalArgumentException("Formato de fecha incorrecto. La fecha ingresada debe ser anterior a la fecha actual.");
                        }
                    }catch (DateTimeException errorFecha){
                        throw new IllegalArgumentException("Formato de fecha incorrecto. Número de días, meses o años fuera de rango");
                    }
                    String correo = caCorreo.getText().isEmpty() ? null : caCorreo.getText().toUpperCase();
                    String domicilio = caDomicilio.getText().isEmpty() ? null : caDomicilio.getText().toUpperCase();
                    String nroTelefono = caNroTelefono.getText().isEmpty() ? null : caNroTelefono.getText().toUpperCase();;
                    String tipoDocumento = caTipoDocumento.getText().isEmpty() ? null : caTipoDocumento.getText().toUpperCase();
                    String nroDocumento = caNroDocumento.getText().isEmpty() ? null : caNroDocumento.getText().toUpperCase();

                    if (nombre == null || apellido == null || correo == null || domicilio == null || tipoDocumento == null || nroDocumento == null) {
                        throw new IllegalArgumentException("Hay campos vacíos.");
                    }

                    if (gestorCliente.buscar(nroDocumento) != null) {
                        throw new IllegalArgumentException("Ya existe un cliente con ese número de documento.");
                    }

                    gestorCliente.agregar(nombre,apellido,fechaNacimiento,correo,domicilio,nroTelefono,tipoDocumento,nroDocumento);
                    JOptionPane.showMessageDialog(null,"Cliente Registrado","",JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null,"Error al intentar registrar el cliente: \n Puede que haya ingresado caracteres en lugar de números.","Error",JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException error) {
                    JOptionPane.showMessageDialog(null,"Error al intentar registrar el cliente: \n" + error.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null,"Error al intentar registrar el cliente.","Error",JOptionPane.ERROR_MESSAGE);
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
