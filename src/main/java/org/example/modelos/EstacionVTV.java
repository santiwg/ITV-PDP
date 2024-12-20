package org.example.modelos;

public class EstacionVTV {
    private int numero;
    private String provincia;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String correo;

    public EstacionVTV() {
    }

    public EstacionVTV(int numero, String provincia, String ciudad, String direccion, String telefono, String correo) {
        this.numero = numero;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return numero+". "+ciudad+ ',' +provincia ;
    }
}
