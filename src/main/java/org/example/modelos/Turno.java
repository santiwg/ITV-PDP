package org.example.modelos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    private LocalDate fecha;
    private LocalTime hora;
    private EstacionVTV estacionVTV;

    public Turno() {
    }

    public Turno(LocalDate fecha, LocalTime hora, EstacionVTV estacionVTV) {
        this.fecha = fecha;
        this.hora = hora;
        this.estacionVTV = estacionVTV;
    }

    public LocalDate getFecha() {return fecha;}

    public void setFecha(LocalDate fecha) {this.fecha = fecha;}

    public LocalTime getHora() {return hora;}

    public void setHora(LocalTime hora) {this.hora = hora;}

    public EstacionVTV getEstacionVTV() {return estacionVTV;}

    public void setEstacionVTV(EstacionVTV estacionVTV) {this.estacionVTV = estacionVTV;}
}
