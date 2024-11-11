package org.example.modelos;

public class TipoVehiculo {

    private String nombre;
    private String descripcion;
    private double peso;


    public TipoVehiculo() {
    }

    public TipoVehiculo(String nombre, double peso, String descripcion) {
        this.descripcion = descripcion;
        this.peso = peso;
        this.nombre = nombre;
    }

    //le hago otro constructor por si no quiero poner descripción
    public TipoVehiculo(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return (nombre +
                " Descripcion=" + descripcion +
                " Peso=" + peso)
                ;
    }
}
