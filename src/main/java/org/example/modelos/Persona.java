package org.example.modelos;
import java.time.LocalDate;
import java.util.Date;

public abstract class Persona {

    protected String nombre;
    protected String apellido;
    protected LocalDate fechaNacimiento;
    protected String correo;
    protected String domicilio;
    protected String nroTelefono;
    protected String tipoDocumento;
    protected String nroDocumento;


    public Persona(){

    }

    public Persona(String nombre, String apellido, LocalDate fechaNacimiento, String correo, String domicilio, String nroTelefono, String tipoDocumento, String nroDocumento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.domicilio = domicilio;
        this.nroTelefono = nroTelefono;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public int calcularEdad(){

        // Calcula la diferencia y devuelve los años de edad
        return fechaNacimiento.until(LocalDate.now()).getYears();
    }

}
