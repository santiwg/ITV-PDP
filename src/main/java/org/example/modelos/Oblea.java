package org.example.modelos;

import java.util.Date;

public class Oblea {
    private int nroOblea;
    private Date fechaAlta;
    private Date fechaConsumo;

    public Oblea() {
    }

    public Oblea(int nroOblea, Date fechaConsumo, Date fechaAlta) {
        this.nroOblea = nroOblea;
        this.fechaConsumo = fechaConsumo;
        this.fechaAlta = fechaAlta;
    }

    public int getNroOblea() {
        return nroOblea;
    }

    public void setNroOblea(int nroOblea) {
        this.nroOblea = nroOblea;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaConsumo() {
        return fechaConsumo;
    }

    public void setFechaConsumo(Date fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }
}
