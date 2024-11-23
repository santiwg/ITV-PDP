package org.example.gestores;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.example.interfaces.IGestor;
import org.example.modelos.*;

public class GestorRevision implements IGestor {
    private ArrayList<Revision> listaRevisiones = new ArrayList<Revision>();
    private GestorVehiculo gestorVehiculo;
    private GestorCliente gestorCliente;
    private GestorEstacionVTV gestorEstacionVTV;

    public GestorRevision() {
    }

    public GestorRevision(GestorVehiculo gestorVehiculo, GestorCliente gestorCliente, GestorEstacionVTV gestorEstacionVTV) {
        this.gestorVehiculo = gestorVehiculo;
        this.gestorCliente = gestorCliente;
        this.gestorEstacionVTV = gestorEstacionVTV;
    }

    public GestorVehiculo getGestorVehiculo() {
        return gestorVehiculo;
    }

    public GestorEstacionVTV getGestorEstacionVTV() {
        return gestorEstacionVTV;
    }

    public void setGestorEstacionVTV(GestorEstacionVTV gestorEstacionVTV) {
        this.gestorEstacionVTV = gestorEstacionVTV;
    }

    public ArrayList<Revision> getListaRevisiones() {
        return listaRevisiones;
    }

    public void setListaRevisiones(ArrayList<Revision> listaRevisiones) {
        this.listaRevisiones = listaRevisiones;
    }

    public void setGestorVehiculo(GestorVehiculo gestorVehiculo) {
        this.gestorVehiculo = gestorVehiculo;
    }

    public GestorCliente getGestorCliente() {
        return gestorCliente;
    }

    public void setGestorCliente(GestorCliente gestorCliente) {
        this.gestorCliente = gestorCliente;
    }

    public ArrayList<Revision> getRevisiones() {
        return listaRevisiones;
    }

    public void setRevisiones(ArrayList<Revision> revisiones) {
        this.listaRevisiones = revisiones;
    }

    public int getNumeroRevision() { // Este método es empleado para generar el número de la próxima revisión que se registre.
        return listaRevisiones.size() + 1;
    }

    public void agregarRevision(int nroRevision, Cliente cliente, Vehiculo vehiculo, Medicion medicion,
                                DefectoRevision defecto, Oblea oblea, LocalDate fechaAlta, String resultado,
                                LocalDate fechaVencimiento, Empleado supervisor, EstacionVTV estacion, Cobro pago,
                                DefectoVisual defectoVisual) {
        Revision r = new Revision(nroRevision, cliente, vehiculo, medicion, defecto, oblea, fechaAlta, resultado,
                fechaVencimiento, supervisor, estacion, pago, defectoVisual);
        listaRevisiones.add(r);
    }


    public void cargarDatosDesdeArchivo(String archivo){ //solo tenemos en cuenta los atributos que utilizan en los CU
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); // lee la línea de títulos, si la tienes

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 5) { // si la línea tiene todos los atributos
                    int nroRevision = Integer.parseInt(datos[0].trim());
                    Cliente cliente = gestorCliente.buscar(datos[1].trim());
                    Vehiculo vehiculo=gestorVehiculo.buscar(datos[2].trim());
                    EstacionVTV estacionVTV = gestorEstacionVTV.buscar(datos[3].trim());
                    List<Integer> fecha = Arrays.stream(datos[4].trim().split("/"))
                            .map(Integer::parseInt).collect(Collectors.toList());
                    int diaNacimiento = fecha.get(0);
                    int mesNacimiento = fecha.get(1);
                    int anioNacimiento = fecha.get(2);
                    LocalDate fechaAlta=LocalDate.of(anioNacimiento,mesNacimiento,diaNacimiento);
                    listaRevisiones.add(new Revision(nroRevision, cliente, vehiculo, estacionVTV, fechaAlta));
                }
                else {
                    System.out.println("Formato incorrecto en archivo de revisiones");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public void cargarEnArchivo(String archivo, Revision revision) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            String nuevaLinea = revision.getNroRevision() + "," + revision.getCliente().getNroDocumento()+ "," +revision.getVehiculo().getPatente()+"," +
                    revision.getEstacion().getNumero()+"," +revision.getFechaAlta().getDayOfMonth() + "/" + revision.getFechaAlta().getMonthValue() + "/" + revision.getFechaAlta().getYear();


            writer.newLine(); // Inserta una nueva línea antes de escribir
            writer.write(nuevaLinea); // Escribe la nueva línea en el archivo

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }


    public void agregarRevision(int nroRevision, Cliente cliente, Vehiculo vehiculo, EstacionVTV estacion,LocalDate fechaAlta) {
        Revision r = new Revision(nroRevision, cliente, vehiculo, estacion,fechaAlta);
        listaRevisiones.add(r);
        cargarEnArchivo("src/main/java/org/example/archivos/Revisiones.txt",r);
    }

    public Revision buscar(String num) {
        return listaRevisiones.stream().filter(r -> r.getNroRevision() == Integer.parseInt(num)).findFirst().orElse(null);
    }

    public ArrayList<Revision> buscarRevisionesCliente(String numDocumento) {
        return this.listaRevisiones.stream().filter(r -> r.getCliente().getNroDocumento().equals(numDocumento)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Revision> buscarRevisionesVehiculo(String patente) {
        return this.listaRevisiones.stream().filter(r -> r.getVehiculo().getPatente().equals(patente)).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Revision> buscarRevisionesClienteYVehiculo(String numDocumento, String patente){
        return this.listaRevisiones.stream().filter(r -> r.getCliente().getNroDocumento().equals(numDocumento)).filter(r -> r.getVehiculo().getPatente().equals(patente)).collect(Collectors.toCollection(ArrayList::new));
    }
}