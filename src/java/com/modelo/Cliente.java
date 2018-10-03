
package com.modelo;

/**
 *
 * @author Ernesto Aviles
 */
public class Cliente {
    private int codigoCliente;
    private String nombre;
    private String apellido;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int codigoCliente, String nombre, String apellido, String direccion) {
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
