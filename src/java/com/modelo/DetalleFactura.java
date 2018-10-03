
package com.modelo;

/**
 *
 * @author Ernesto Aviles
 */
public class DetalleFactura {
    private int codigoDetalle;
    private int codigoFactura;
    private int codigoProducto;
    private String codigoBarra;
    private String nombreProducto;
    private int cantida;
    private double precioVenta;
    private double total;

    public DetalleFactura() {
    }

    public DetalleFactura(int codigoDetalle, int codigoFactura, int codigoProducto, String codigoBarra, String nombreProducto, int cantida, double precioVenta, double total) {
        this.codigoDetalle = codigoDetalle;
        this.codigoFactura = codigoFactura;
        this.codigoProducto = codigoProducto;
        this.codigoBarra = codigoBarra;
        this.nombreProducto = nombreProducto;
        this.cantida = cantida;
        this.precioVenta = precioVenta;
        this.total = total;
    }

    public int getCodigoDetalle() {
        return codigoDetalle;
    }

    public void setCodigoDetalle(int codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantida() {
        return cantida;
    }

    public void setCantida(int cantida) {
        this.cantida = cantida;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
