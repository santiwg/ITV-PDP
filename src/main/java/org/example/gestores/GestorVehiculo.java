package org.example.gestores;

import org.example.modelos.TipoVehiculo;
import org.example.modelos.Vehiculo;

import java.io.*;
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
    public void cargarDatosDesdeArchivo(String archivo){
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); // lee la línea de títulos, si la tienes

            while ((linea = br.readLine()) != null) { // mientras haya más líneas
                String[] datos = linea.split(","); // separa los datos

                if (datos.length == 9) { // si la línea tiene todos los atributos
                    String patente = datos[0].trim();
                    String marca = datos[1].trim();
                    String modelo = datos[2].trim();
                    String nroChasis = datos[3].trim();
                    int anioFabricacion = Integer.parseInt(datos[4].trim());
                    double kilometros = Double.parseDouble(datos[5].trim());
                    String tipoCombustible = datos[6].trim();
                    int cantidadEjes = Integer.parseInt(datos[7].trim());

                    // Busca el tipo de vehículo por su nombre
                    String nombreTipoVehiculo = datos[8].trim();
                    TipoVehiculo tipoVehiculo = gestorTV.buscar(nombreTipoVehiculo);

                    // Crea la instancia de la clase con los datos leídos
                    listaVehiculos.add(new Vehiculo(tipoVehiculo,tipoCombustible,patente,nroChasis,modelo,marca,kilometros,anioFabricacion,cantidadEjes));
                }
                else {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public void agregar(TipoVehiculo tipovehiculo, String tipoCombustible, String patente, String nroChasis, String modelo, String marca, double kilometros, int anioFabricacion, int cantEjes) {
        Vehiculo v=new Vehiculo(tipovehiculo,tipoCombustible,patente,nroChasis,modelo,marca,kilometros,anioFabricacion,cantEjes);
        listaVehiculos.add(v);
        cargarEnArchivo("src/main/java/org/example/archivos/Vehiculos.txt",v);
    }
    public void cargarEnArchivo(String archivo, Vehiculo v) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            String nuevaLinea=v.getPatente()+','+v.getModelo()+','+v.getMarca()+','+v.getNroChasis()+','+String.valueOf(v.getAnioFabricacion())
            +','+String.valueOf(v.getKilometros())+','+v.getTipoCombustible()+','+String.valueOf(v.getCantidadEjes())+','+v.getTipovehiculo().getNombre();
            // Escribe el texto en una nueva línea al final del archivo
            writer.newLine(); // Inserta una nueva línea
            writer.write(nuevaLinea); // Escribe el contenido
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    public Vehiculo buscar(String pat) {
        return listaVehiculos.stream().filter(v -> v.getPatente().equals(pat)).findFirst().orElse(null);
    }

}
