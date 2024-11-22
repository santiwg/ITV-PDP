package org.example.gestores;

import org.example.modelos.EstacionVTV;
import org.example.modelos.TipoVehiculo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorEstacionVTV {
    private ArrayList<EstacionVTV> listaEstaciones=new ArrayList<>();

    public GestorEstacionVTV() {
    }

    public ArrayList<EstacionVTV> getListaEstaciones() {
        return listaEstaciones;
    }

    public void setListaEstaciones(ArrayList<EstacionVTV> listaEstaciones) {
        this.listaEstaciones = listaEstaciones;
    }

    public void agregar(EstacionVTV estacionVTV){

        listaEstaciones.add(estacionVTV);
    }

    public void cargarDatosDesdeArchivo(String archivo){
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine();//linea de titulos, si la tengo, de esta manera la leo pero no la utilizo
            while ((linea = br.readLine()) != null) {//mientras haya una linea mas en el archivo
                String[] datos = linea.split(","); //tomo los datos
                //numero,provincia,ciudad,direccion,telefono,correo
                if (datos.length == 6) { //si tiene todos los datos
                    int num=Integer.parseInt(datos[0].trim());
                    String provincia = datos[1].trim();
                    String ciudad = datos[2].trim();
                    String direccion = datos[3].trim();
                    String telefono = datos[4].trim();
                    String correo = datos[5].trim();
                    agregar(new EstacionVTV(num,provincia,ciudad,direccion,telefono,correo));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public EstacionVTV buscar(Integer num) {
        return listaEstaciones.stream().filter(t -> t.getNumero()==(num)).findFirst().orElse(null);
    }
}
