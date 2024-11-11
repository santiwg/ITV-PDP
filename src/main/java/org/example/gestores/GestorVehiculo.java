package org.example.gestores;

import org.example.modelos.TipoVehiculo;
import org.example.modelos.Vehiculo;

import java.util.ArrayList;

public class GestorVehiculo {
private ArrayList<Vehiculo> listaVehiculos=new ArrayList<>();
private GestorTipoVehiculo gestorTV;

    public GestorVehiculo(GestorTipoVehiculo gestorTV) {
        this.gestorTV = gestorTV;
    }

    public GestorVehiculo() {
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public GestorTipoVehiculo getGestorTV() {
        return gestorTV;
    }

    public void setGestorTV(GestorTipoVehiculo gestorTV) {
        this.gestorTV = gestorTV;
    }
    public void agregar(TipoVehiculo tipovehiculo, String tipoCombustible, String patente, String nroChasis, String modelo, String marca, double kilometros, int anioFabricacion, int cantEjes) {
        listaVehiculos.add(new Vehiculo(tipovehiculo,tipoCombustible,patente,nroChasis,modelo,marca,kilometros,anioFabricacion,cantEjes));
    }
    public Vehiculo buscar(String pat) {
        for (Vehiculo v: listaVehiculos){
            if (v.getPatente().equals(pat)){
                return v;
            }
        }
        return null;
    }
}
