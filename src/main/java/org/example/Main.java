package org.example;

import org.example.gestores.GestorTipoVehiculo;
import org.example.gestores.GestorVehiculo;
import org.example.pantallas.PantallaPrincipal;

public class Main {
    public static void main(String[] args) {
        GestorTipoVehiculo gestorTipoVehiculo=new GestorTipoVehiculo();
        gestorTipoVehiculo.cargarDatosDesdeArchivo("src/main/java/org/example/Tipos Vehículo.txt");
        GestorVehiculo gestorVehiculo=new GestorVehiculo(gestorTipoVehiculo);


        new PantallaPrincipal(gestorVehiculo);



    }
}