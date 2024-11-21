package org.example.modelos;

public class DefectoRevision {
    private int valor;
    private DefectoVisual defecto;

    public DefectoRevision() {
    }

    public DefectoRevision(int valor, DefectoVisual defecto) {
        this.valor = valor;
        this.defecto = defecto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public DefectoVisual getDefecto() {
        return defecto;
    }

    public void setDefecto(DefectoVisual defecto) {
        this.defecto = defecto;
    }
}
