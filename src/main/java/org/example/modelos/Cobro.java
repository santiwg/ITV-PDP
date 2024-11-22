package org.example.modelos;

public class Cobro {
    private Tarifa tarifa;
    private double precio;
    private int nroFactura;

    public Cobro() {
    }

    public Cobro(Tarifa tarifa, double precio, int nroFactura) {
        this.tarifa = tarifa;
        this.precio = precio;
        this.nroFactura = nroFactura;
    }

    public Tarifa getTarifa() {return tarifa;}

    public void setTarifa(Tarifa tarifa) {this.tarifa = tarifa;}

    public double getPrecio() {return precio;}

    public void setPrecio(double precio) {this.precio = precio;}

    public int getNroFactura() {return nroFactura;}

    public void setNroFactura(int nroFactura) {this.nroFactura = nroFactura;}

    public void generarComprobante(){
        //esta funcionalidad no se implementa aquí
    }
}
