package org.example.gestores;

import org.example.interfaces.IGestor;
import org.example.modelos.Cliente;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class GestorCliente implements IGestor {
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
                    List<Integer> fecha = Arrays.stream(datos[2].trim().split("/"))
                            .map(Integer::parseInt).collect(Collectors.toList());
                    int diaNacimiento = fecha.get(0);
                    int mesNacimiento = fecha.get(1);
                    int anioNacimiento = fecha.get(2);
                    LocalDate fechaNacimiento=LocalDate.of(anioNacimiento,mesNacimiento,diaNacimiento);
                    String correo = datos[3].trim();
                    String domicilio = datos[4].trim();
                    String nroTelefono = datos[5].trim();
                    String tipoDocumento = datos[6].trim();
                    String nroDocumento = datos[7].trim();

                    // Crea la instancia de la clase con los datos leídos
                    listaClientes.add(new Cliente(nombre,apellido,fechaNacimiento,correo,domicilio,nroTelefono,tipoDocumento,nroDocumento));
                }
                else {
                    System.out.println("Formato incorrecto en archivo de clientes");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public void agregar(String nombre, String apellido,LocalDate fechaNacimiento, String correo, String domicilio, String nroTelefono, String tipoDocumento, String nroDocumento) {
        Cliente c = new Cliente(nombre,apellido,fechaNacimiento,correo,domicilio,nroTelefono,tipoDocumento,nroDocumento);
        listaClientes.add(c);
        cargarEnArchivo("src/main/java/org/example/archivos/Clientes.txt",c);
    }
    public void cargarEnArchivo(String archivo, Cliente cliente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            String nuevaLinea = cliente.getNombre() + "," + cliente.getApellido() + "," +cliente.getFechaNacimiento().getDayOfMonth() + "/" + cliente.getFechaNacimiento().getMonthValue() + "/" + cliente.getFechaNacimiento().getYear() + "," +
                    cliente.getCorreo() + "," + cliente.getDomicilio() + "," +cliente.getNroTelefono() + "," + cliente.getTipoDocumento() + "," +cliente.getNroDocumento();

            writer.newLine(); // Inserta una nueva línea antes de escribir
            writer.write(nuevaLinea); // Escribe la nueva línea en el archivo

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public Cliente buscar(String doc) {
        return listaClientes.stream().filter(c -> c.getNroDocumento().equals(doc)).findFirst().orElse(null);
    }
}
