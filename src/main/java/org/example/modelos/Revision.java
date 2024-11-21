package org.example.modelos;

import java.util.Date;

public class Revision {
    private int nroRevision;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Medicion medicion;
    private DefectoRevision defecto;
    private Oblea oblea;
    private Date fechaAlta;
    private String resultado;
    private Date fechaVencimiento;
    private Empleado supervisor;
    private EstacionVTV estacion;
    private Cobro pago;
    private DefectoVisual defectoVisual;

    public Revision() {
    }

    public Revision(int nroRevision, Cliente cliente, Vehiculo vehiculo, Medicion medicion, DefectoRevision defecto,Oblea oblea, Date fechaAlta, String resultado, Date fechaVencimiento, Empleado supervisor, EstacionVTV estacion, Cobro pago, DefectoVisual defectoVisual) {
        this.nroRevision = nroRevision;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.medicion = medicion;
        this.defecto = defecto;
        this.oblea = oblea;
        this.fechaAlta = fechaAlta;
        this.resultado = resultado;
        this.fechaVencimiento = fechaVencimiento;
        this.supervisor = supervisor;
        this.estacion = estacion;
        this.pago = pago;
        this.defectoVisual = defectoVisual;
    }
    public int getNroRevision() {
        return nroRevision;
    }

    public void setNroRevision(int nroRevision) {
        this.nroRevision = nroRevision;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public Medicion getMedicion() {
        return medicion;
    }
    public void setMedicion(Medicion medicion) {
        this.medicion = medicion;
    }
    public DefectoRevision getDefecto() {
        return defecto;
    }
    public void setDefecto(DefectoRevision defecto) {
        this.defecto = defecto;
    }
    public Oblea getOblea() {
        return oblea;
    }
    public void setOblea(DefectoRevision defecto) {
        this.oblea = oblea;
    }
    public Date getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public String getResultado() {
        return resultado;
    }
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public Empleado getSupervisor() {
        return supervisor;
    }
    public void setSupervisor(Empleado supervisor) {
        this.supervisor = supervisor;
    }
    public EstacionVTV getEstacion() {
        return estacion;
    }
    public void setEstacion(EstacionVTV estacion) {
        this.estacion = estacion;
    }
    public DefectoVisual getDefectoVisual() {
        return defectoVisual;
    }
    public void setDefectoVisual(DefectoVisual defectoVisual) {
        this.defectoVisual = defectoVisual;
    }

    public boolean asignarOblea(Vehiculo v){
        //esta es una funcionalidad de otro sistema, no se la implementa aquí
        return true;
    }

    public boolean calcularResultado(Vehiculo v){
        //esta es una funcionalidad de otro sistema, no se la implementa aquí
        return true;
    }

    public boolean emitirInforme(Vehiculo v){
        //esta es una funcionalidad de otro sistema, no se la implementa aquí
        return true;
    }


}
=======
import java.time.LocalDate;

public class Revision {
        private int nroRevision;
        private Cliente cliente;
        private Vehiculo vehiculo;
        private Medición medicion;
        private DefectoRevisión defecto;
        private Oblea oblea;
        private LocalDate fechaAlta;
        private String resultado;
        private LocalDate fechaVencimiento;
        private Empleado supervisor;
        private EstacionVTV estacion;
        private Cobro pago;
        private DefectoVisual defectoVisual;

        public Revision() {
        }

        public Revision(int nroRevision, Cliente cliente, Vehiculo vehiculo, Medición medicion, DefectoRevisión defecto,Oblea oblea, LocalDate fechaAlta, String resultado, LocalDate fechaVencimiento, Empleado supervisor, EstacionVTV estacion, Cobro pago, DefectoVisual defectoVisual) {
            this.nroRevision = nroRevision;
            this.cliente = cliente;
            this.vehiculo = vehiculo;
            this.medicion = medicion;
            this.defecto = defecto;
            this.oblea = oblea;
            this.fechaAlta = fechaAlta;
            this.resultado = resultado;
            this.fechaVencimiento = fechaVencimiento;
            this.supervisor = supervisor;
            this.estacion = estacion;
            this.pago = pago;
            this.defectoVisual = defectoVisual;
        }

    public Revision(int nroRevision, Cliente cliente, Vehiculo vehiculo, EstacionVTV estacion) {
        this.nroRevision = nroRevision;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.estacion = estacion;
        this.fechaAlta = LocalDate.now();
    }

    public int getNroRevision() {
            return nroRevision;
        }

        public void setNroRevision(int nroRevision) {
            this.nroRevision = nroRevision;
        }
        public Cliente getCliente() {
            return cliente;
        }
        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }
        public Vehiculo getVehiculo() {
            return vehiculo;
        }
        public void setVehiculo(Vehiculo vehiculo) {
            this.vehiculo = vehiculo;
        }
        public Medición getMedicion() {
            return medicion;
        }
        public void setMedicion(Medición medicion) {
            this.medicion = medicion;
        }
        public DefectoRevisión getDefecto() {
            return defecto;
        }
        public void setDefecto(DefectoRevisión defecto) {
            this.defecto = defecto;
        }
        public Oblea getOblea() {
            return oblea;
        }
        public void setOblea(DefectoRevisión defecto) {
            this.oblea = oblea;
        }
        public Date getFechaAlta() {
            return fechaAlta;
        }
        public void setFechaAlta(Date fechaAlta) {
            this.fechaAlta = fechaAlta;
        }
        public String getResultado() {
            return resultado;
        }
        public void setResultado(String resultado) {
            this.resultado = resultado;
        }
        public Date getFechaVencimiento() {
            return fechaVencimiento;
        }

        public void setFechaVencimiento(Date fechaVencimiento) {
            this.fechaVencimiento = fechaVencimiento;
        }
        public Empleado getSupervisor() {
            return supervisor;
        }
        public void setSupervisor(Empleado supervisor) {
            this.supervisor = supervisor;
        }
        public EstacionVTV getEstacion() {
            return estacion;
        }
        public void setEstacion(EstacionVTV estacion) {
            this.estacion = estacion;
        }
        public DefectoVisual getDefectoVisual() {
            return defectoVisual;
        }
        public void setDefectoVisual(DefectoVisual defectoVisual) {
            this.defectoVisual = defectoVisual;
        }

        public boolean asignarOblea(Vehiculo v){
            //esta es una funcionalidad de otro sistema, no se la implementa aquí
            return true;
        }

        public boolean calcularResultado(Vehiculo v){
            //esta es una funcionalidad de otro sistema, no se la implementa aquí
            return true;
        }

        public boolean emitirInforme(Vehiculo v){
            //esta es una funcionalidad de otro sistema, no se la implementa aquí
            return true;
        }


    }

>>>>>>> Stashed changes
