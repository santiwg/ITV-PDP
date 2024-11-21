package org.example.gestores;

import org.example.modelos.Cliente;

import java.io.*;
import java.util.ArrayList;

public class GestorCliente {
    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    public GestorCliente(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    public GestorCliente(){}

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
   public void cargarDatosDesdeArchivo(String archivo){
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); // lee la línea de títulos, si la tienes

            while ((linea = br.readLine()) != null) { // mientras haya más líneas
                String[] datos = linea.split(","); // separa los datos

                if (datos.length == 8) { // si la línea tiene todos los atributos
                    String nombre = datos[0].trim();
                    String apellido = datos[1].trim();
                    int fechaNacimiento = Integer.parseInt(datos[2].trim());// Hay que pasarla a Date
                    String correo = datos[3].trim();
                    String domicilio = datos[4].trim();
                    int nroTelefono = Integer.parseInt(datos[5].trim());
                    String tipoDocumento = datos[6].trim();
                    String nroDocumento = datos[7].trim();

                    // Crea la instancia de la clase con los datos leídos
                    Cliente cliente = new Cliente(nombre,apellido,fechaNacimiento,correo,domicilio,nroTelefono,tipoDocumento,nroDocumento);
                    listaClientes.add(cliente);
                }
                else {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public void agregar(String nombre, String apellido,int fechaNacimiento, String correo, String domicilio, int nroTelefono, String tipoDocumento, String nroDocumento) {
        Cliente c = new Cliente(nombre,apellido,fechaNacimiento,correo,domicilio,nroTelefono,tipoDocumento,nroDocumento);
        listaClientes.add(c);
        cargarEnArchivo("src/main/java/org/example/Clientes.txt",c);
    }
    public void cargarEnArchivo(String archivo, Cliente c) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            String nuevaLinea=c.getNroDocumento() + ',' + c.getNombre() + ',' + c.getApellido() + ',' + String.valueOf(c.getFechaNacimiento())
                    + ',' + c.getTipoDocumento() + ',' + c.getCorreo() + ',' + c.getDomicilio() + ',' + String.valueOf(c.getNroTelefono());
            // Escribe el texto en una nueva línea al final del archivo
            writer.newLine(); // Inserta una nueva línea
            writer.write(nuevaLinea); // Escribe el contenido
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    public Cliente buscar(String doc) {
        for (Cliente c: listaClientes){
            if (c.getNroDocumento().equals(doc)){
                return c;
            }
        }
        return null;
    }
}
