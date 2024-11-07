package org.example.modelos;

import java.util.Date;

public class Cliente extends Persona{

    private String turno; //Es tipo Cita

    public Cliente(String nombre, String apellido, Date fechaNacimiento, String correo, String domicilio, int nroTelefono, String tipoDocumento, String nroDocumento) {
        super(nombre, apellido, fechaNacimiento, correo, domicilio, nroTelefono, tipoDocumento, nroDocumento);
    }

    public Cliente(String nombre, String apellido, Date fechaNacimiento, String correo, String domicilio, int nroTelefono, String tipoDocumento, String nroDocumento, String turno) {
        super(nombre, apellido, fechaNacimiento, correo, domicilio, nroTelefono, tipoDocumento, nroDocumento);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void validarCliente(Cliente c){
        //esta es una funcionalidad de otro sistema, no se la implementa aquí
    }
}
