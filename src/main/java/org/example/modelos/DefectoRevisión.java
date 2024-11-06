package org.example.modelos;

public class DefectoRevisión {
    private int valor;
    private DefectoVisual defecto;

    public DefectoRevisión() {
    }

    public DefectoRevisión(int valor, DefectoVisual defecto) {
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
