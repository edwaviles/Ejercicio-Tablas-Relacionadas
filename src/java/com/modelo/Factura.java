
package com.modelo;

import com.conexion.Conexion;
import  java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *Nombre de la clase: Ventas
 * Version: 1.0
 * Fecha: 26/09/2018
 * Copyright: Ernesto Aviles
 * @author Ernesto Aviles
 */
public class Factura extends Conexion{
    private int codigoFactura;
    private String numeroFactura;
    private int codigoVendedor;
    private int codigoCliente;
    private double totalVenta;
    private String fechaRegitro;

    public Factura() {
    }

    public Factura(int codigoFactura, String numeroFactura, int codigoVendedor, int codigoCliente, double totalVenta, String fechaRegitro) {
        this.codigoFactura = codigoFactura;
        this.numeroFactura = numeroFactura;
        this.codigoVendedor = codigoVendedor;
        this.codigoCliente = codigoCliente;
        this.totalVenta = totalVenta;
        this.fechaRegitro = fechaRegitro;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getFechaRegitro() {
        return fechaRegitro;
    }

    public void setFechaRegitro(String fechaRegitro) {
        this.fechaRegitro = fechaRegitro;
    }
    
    
    
    
}
