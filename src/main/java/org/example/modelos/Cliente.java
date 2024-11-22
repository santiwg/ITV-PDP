package org.example.modelos;

import java.time.LocalDate;
import java.util.Date;

public class Cliente extends Persona{

    //La siguiente parte esta comentada ya que no se implementa el turno en este sistema

    /*private String turno;
        public Cliente(String nombre, String apellido, Date fechaNacimiento, String correo, String domicilio, int nroTelefono, String tipoDocumento, String nroDocumento, String turno) {
        super(nombre, apellido, fechaNacimiento, correo, domicilio, nroTelefono, tipoDocumento, nroDocumento);
        this.turno = turno;
    }

    public Cita getTurno() {
        return turno;
    }

    public void setTurno(Cita turno) {
        this.turno = turno;
    }*/

    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento, String correo, String domicilio, int nroTelefono, String tipoDocumento, String nroDocumento) {
        super(nombre, apellido, fechaNacimiento, correo, domicilio, nroTelefono, tipoDocumento, nroDocumento);
    }

    public void validarCliente(Cliente c){
        //esta es una funcionalidad de otro sistema, no se la implementa aquí
    }
}
