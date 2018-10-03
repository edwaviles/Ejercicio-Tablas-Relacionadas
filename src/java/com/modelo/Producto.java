
package com.modelo;

/**
 *
 * @author Ernesto Aviles
 */
public class Producto {
    private int codigoProducto;
    private String nombreProducto;
    private double precioVenta;
    private int stockMinimo;
    private int stockAnual;
    private String codigoBarra;

    public Producto() {
    }

    public Producto(int codigoProducto, String nombreProducto, double precioVenta, int stockMinimo, int stockAnual, String codigoBarra) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precioVenta = precioVenta;
        this.stockMinimo = stockMinimo;
        this.stockAnual = stockAnual;
        this.codigoBarra = codigoBarra;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockAnual() {
        return stockAnual;
    }

    public void setStockAnual(int stockAnual) {
        this.stockAnual = stockAnual;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
   
    
}
