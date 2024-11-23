package org.example.interfaces;

public interface IGestor {
    Object buscar(String criterio);

    void cargarDatosDesdeArchivo(String archivo);
}
