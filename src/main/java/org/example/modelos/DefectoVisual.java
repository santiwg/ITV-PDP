package org.example.modelos;

public class DefectoVisual {
    private String nombre;
    private String descripcion;
    private String tipo;
    private int numero;

    public DefectoVisual(String nombre, String descripcion, String tipo, int numero) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
