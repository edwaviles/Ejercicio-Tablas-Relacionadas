
package com.modelo;

/**
 *Nombre de la clase:26/09/2018
 * Fecha:26/09/2018
 * CopyRight:ITCA
 * Version:1.0
 * @author Lopez
 */
public class Usuario {
    
    private int codigoUsuario;
    private String nombreUsuario; 
    private String pass;
    private int codigoRol;
    private Rol rol;

    
     public Usuario()
    {
        
    } 
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
   
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }
    
    
}
