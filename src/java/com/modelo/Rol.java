
package com.modelo;

/**
 *
 * @author Lopez
 */
public class Rol {
    private int codigoRol;
    private String nombreRol;

    public Rol() {
    }   

    public Rol(int codigoRol, String nombreRol) {
        this.codigoRol = codigoRol;
        this.nombreRol = nombreRol;
    }

    public int getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
    
}
