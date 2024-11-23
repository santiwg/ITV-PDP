package org.example;

import org.example.gestores.*;
import org.example.pantallas.PantallaPrincipal;

public class Main {

    /* INTEGRANTES DEL GRUPO:
     *
     * Barrionuevo Halavacs, Imanol
     * Broilo, Mateo
     * Correa, Valentin
     * Díaz, Gabriel
     * Gambino, Tomas
     * Gomez, Andres
     * Gonzalez Meyer, Lorenzo
     * Letona, Mateo
     * Wursten Gill, Santiago
     */

    public static void main(String[] args) {
        GestorTipoVehiculo gestorTipoVehiculo=new GestorTipoVehiculo();
        gestorTipoVehiculo.cargarDatosDesdeArchivo("src/main/java/org/example/archivos/Tipos Vehículo.txt");
        GestorVehiculo gestorVehiculo=new GestorVehiculo(gestorTipoVehiculo);
        gestorVehiculo.cargarDatosDesdeArchivo("src/main/java/org/example/archivos/Vehiculos.txt");
        GestorCliente gestorCliente = new GestorCliente();
        gestorCliente.cargarDatosDesdeArchivo("src/main/java/org/example/archivos/Clientes.txt");
        GestorEstacionVTV gestorEstacionVTV=new GestorEstacionVTV();
        gestorEstacionVTV.cargarDatosDesdeArchivo("src/main/java/org/example/archivos/Estaciones.txt");
        GestorRevision gestorRevision=new GestorRevision(gestorVehiculo,gestorCliente,gestorEstacionVTV);
        gestorRevision.cargarDatosDesdeArchivo("src/main/java/org/example/archivos/Revisiones.txt");

        new PantallaPrincipal(gestorVehiculo,gestorCliente,gestorRevision);
    }
}