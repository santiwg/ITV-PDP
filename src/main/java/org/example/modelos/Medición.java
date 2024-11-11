package org.example.modelos;

public class Medición {
    private int nroMedicion;
    private String medida;
    private float valor;
    private String resultado;
    private int seccion;
    private int linea;
    private Empleado inspector;

    public Medición() {
    }

    public Medición(int nroMedicion, String medida, float valor, String resultado, int seccion, int linea, Empleado inspector) {
        this.nroMedicion = nroMedicion;
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
