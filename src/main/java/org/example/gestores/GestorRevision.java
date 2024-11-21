package org.example.gestores;

import java.util.ArrayList;
import java.util.Date;

import org.example.modelos.*;

public class GestorRevision {
    private ArrayList<Revision> listaRevisiones = new ArrayList<Revision>();

    public GestorRevision() {
    }

    public ArrayList<Revision> getRevisiones() {
        return listaRevisiones;
    }

    public void setRevisiones(ArrayList<Revision> revisiones) {
        this.listaRevisiones = revisiones;
    }

    public void agregarRevision(int nroRevision, Cliente cliente, Vehiculo vehiculo, Medicion medicion,
                                DefectoRevision defecto, Oblea oblea, Date fechaAlta, String resultado,
                                Date fechaVencimiento, Empleado supervisor, EstacionVTV estacion, Cobro pago,
                                DefectoVisual defectoVisual){
        Revision r = new Revision(nroRevision, cliente, vehiculo, medicion, defecto, oblea, fechaAlta, resultado,
                 fechaVencimiento,  supervisor,  estacion,  pago, defectoVisual);
        listaRevisiones.add(r);
    }

    public ArrayList<Revision> buscarRevisionesCliente(String numDocumento, String patente){
        ArrayList<Revision> revisionesEncontradas= new ArrayList<>();
        for(Revision revision:listaRevisiones) {
            if(revision.getCliente().getNroDocumento().equals(numDocumento)){
                revisionesEncontradas.add(revision);
            } else if(revision.getVehiculo().getPatente().equals(patente)) {
                revisionesEncontradas.add(revision);
            }
        }
        return revisionesEncontradas;
    }
}
