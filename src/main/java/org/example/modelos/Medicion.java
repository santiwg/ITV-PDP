package org.example.modelos;

public class Medicion {
    private int numeroMedicion;
    private String medida;
    private float valor;
    private String resultado;
    private int seccion;
    private int linea;
    private Empleado inspector;

    public Medicion() {
    }

    public Medicion(int numeroMedicion, String medida, float valor, String resultado, int seccion, int linea, Empleado inspector) {
        this.numeroMedicion = numeroMedicion;
        this.medida = medida;
        this.valor = valor;
        this.resultado = resultado;
        this.seccion = seccion;
        this.linea = linea;
        this.inspector = inspector;
    }

    public void calcularResultado(){

    }
}