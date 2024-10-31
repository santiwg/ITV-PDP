package org.example.modelos;

public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private String nroChasis;
    private int anioFabricación;
    private double kilometros;
    private String tipoCombustible;
    private int cantidadEjes;
    private TipoVehiculo tipovehiculo;


    public Vehiculo() {
    }

    public Vehiculo(int anioFabricación, TipoVehiculo tipovehiculo, String tipoCombustible, int cantidadEjes, double kilometros, String marca, String patente, String nroChasis, String modelo) {
        this.anioFabricación = anioFabricación;
        this.tipovehiculo = tipovehiculo;
        this.tipoCombustible = tipoCombustible;
        this.cantidadEjes = cantidadEjes;
        this.kilometros = kilometros;
        this.marca = marca;
        this.patente = patente;
        this.nroChasis = nroChasis;
        this.modelo = modelo;
    }

    //hago un constructor sin la cantidad de ejes.

    public Vehiculo(TipoVehiculo tipovehiculo, String tipoCombustible, String patente, String nroChasis, String modelo, String marca, double kilometros, int anioFabricación) {
        this.tipovehiculo = tipovehiculo;
        this.tipoCombustible = tipoCombustible;
        this.patente = patente;
        this.nroChasis = nroChasis;
        this.modelo = modelo;
        this.marca = marca;
        this.kilometros = kilometros;
        this.anioFabricación = anioFabricación;
    }

    public TipoVehiculo getTipovehiculo() {
        return tipovehiculo;
    }

    public void setTipovehiculo(TipoVehiculo tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }

    public int getAnioFabricación() {
        return anioFabricación;
    }

    public void setAnioFabricación(int anioFabricación) {
        this.anioFabricación = anioFabricación;
    }

    public int getCantidadEjes() {
        return cantidadEjes;
    }

    public void setCantidadEjes(int cantidadEjes) {
        this.cantidadEjes = cantidadEjes;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNroChasis() {
        return nroChasis;
    }

    public void setNroChasis(String nroChasis) {
        this.nroChasis = nroChasis;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public boolean validarVehiculo(Vehiculo v){
        //esta es una funcionalidad de otro sistema, no se la implementa aquí
        return true;
    }
}
