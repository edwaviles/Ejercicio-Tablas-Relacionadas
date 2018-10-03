
package com.modelo;

/**
 *
 * @author Ernesto Aviles
 */
public class Vendedor {
    private int codigoVendedor;
    private String dui;
    private String nombre;
    private String apellidos;
    private String telefonoOficina;
    private String telefonoMovil;

    public Vendedor() {
    }

    public Vendedor(int codigoVendedor, String dui, String nombre, String apellidos, String telefonoOficina, String telefonoMovil) {
        this.codigoVendedor = codigoVendedor;
        this.dui = dui;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefonoOficina = telefonoOficina;
        this.telefonoMovil = telefonoMovil;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefonoOficina() {
        return telefonoOficina;
    }

    public void setTelefonoOficina(String telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }
    
    
    
}
