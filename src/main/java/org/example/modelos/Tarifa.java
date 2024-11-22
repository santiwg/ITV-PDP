package org.example.modelos;

public class Tarifa {
    private int numero;
    private double precio;
    private String descripcion;

    public Tarifa() {
    }

    public Tarifa(int numero, double precio, String descripcion) {
        this.numero = numero;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public int getNumero() {return numero;}

    public void setNumero(int numero) {this.numero = numero;}

    public double getPrecio() {return precio;}

    public void setPrecio(double precio) {this.precio = precio;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
}
