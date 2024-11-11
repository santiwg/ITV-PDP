package org.example.gestores;

import org.example.modelos.TipoVehiculo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorTipoVehiculo {
private ArrayList<TipoVehiculo> listaTiposVehiculo=new ArrayList<>();

    public GestorTipoVehiculo() {
    }
    public void agregar(TipoVehiculo tipo){
        listaTiposVehiculo.add(tipo);
    }
    public void cargarDatosDesdeArchivo(String archivo){
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine();//linea de titulos, si la tengo, de esta manera la leo pero no la utilizo
            while ((linea = br.readLine()) != null) {//mientras haya una linea mas en el archivo
                String[] datos = linea.split(","); //tomo los datos

                if (datos.length == 3) { //si tiene descripción usa esta opción
                    String nombre = datos[0].trim();
                    double peso = Double.parseDouble(datos[1].trim());
                    String descripcion = datos[2].trim();
                    TipoVehiculo tipo=new TipoVehiculo(nombre,peso,descripcion);
                    listaTiposVehiculo.add(tipo);
                } else if (datos.length == 2){ //si no tiene descripción usa esta opción
                    String nombre = datos[0].trim();
                    double peso = Double.parseDouble(datos[1].trim());
                    TipoVehiculo tipo=new TipoVehiculo(nombre,peso);
                    listaTiposVehiculo.add(tipo);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public TipoVehiculo buscar(String tipo) {
        for (TipoVehiculo t: listaTiposVehiculo){
            if (t.getNombre().equals(tipo)){
                return t;
            }
        }
        return null;
    }

    public ArrayList<TipoVehiculo> getListaTiposVehiculo() {
        return listaTiposVehiculo;
    }

    public void setListaTiposVehiculo(ArrayList<TipoVehiculo> listaTiposVehiculo) {
        this.listaTiposVehiculo = listaTiposVehiculo;
    }
}
