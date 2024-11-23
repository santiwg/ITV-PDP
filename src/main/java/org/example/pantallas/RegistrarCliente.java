package org.example.pantallas;

import org.example.gestores.GestorCliente;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    private GestorCliente gestorCliente;

    public RegistrarCliente(GestorCliente gestorCliente){
        this.gestorCliente=gestorCliente;
        setContentPane(panelPrincipal); //este linea va si o si, sino no podemos trabajar con el panel armado

        setTitle("Registrar Cliente");  //configurar el título de la ventana
        setSize(520,500); //configurar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //define el comportamiento de cierre (lo que hace cuando se toca la cruz)
        setLocationRelativeTo(null); //indicamos respecto a que se centre, al poner null es respecto al centro.
        setVisible(true); //esto es lo más importante, sin esto no va a abrir la ventana


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
                        fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
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
                    new Mensaje("Cliente Registrado");

                } catch (NumberFormatException error) {
                    new Mensaje("Error al intentar registrar el cliente: \n Puede que haya ingresado caracteres en lugar de números.");
                } catch (IllegalArgumentException error) {
                    new Mensaje("Error al intentar registrar el cliente: \n" + error.getMessage());
                } catch (Exception error) {
                    new Mensaje("Error al intentar registrar el cliente.");
                }
            }
        });
    }

}
