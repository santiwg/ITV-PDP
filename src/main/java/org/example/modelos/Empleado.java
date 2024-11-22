package org.example.modelos;
import java.time.LocalDate;
import java.util.Date;

public class Empleado extends Persona{

    private int legajo;
    private String rol;

    public Empleado(String nombre, String apellido, LocalDate fechaNacimiento, String correo, String domicilio, int nroTelefono, String tipoDocumento, String nroDocumento) {
        super(nombre, apellido, fechaNacimiento, correo, domicilio, nroTelefono, tipoDocumento, nroDocumento);
    }

    public Empleado(String nombre, String apellido, LocalDate fechaNacimiento, String correo, String domicilio, int nroTelefono, String tipoDocumento, String nroDocumento, int legajo, String rol) {
        super(nombre, apellido, fechaNacimiento, correo, domicilio, nroTelefono, tipoDocumento, nroDocumento);
        this.legajo = legajo;
        this.rol = rol;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
