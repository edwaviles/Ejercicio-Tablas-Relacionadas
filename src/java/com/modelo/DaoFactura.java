
package com.modelo;

import com.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase: DaoFactura
 * Version: 1.0
 * Fecha: 29/09/2018
 * COpyright: Ernesto Aviles
 * @author Ernesto Aviles
 */
public class DaoFactura extends Conexion{
 
    public List<Factura> mostrarFacturas() throws Exception
    {
        ResultSet res;
        List<Factura> ls=new ArrayList();
        try 
        {
            this.conectar();
            String sq1="select * from factura where totalVenta=0.0;";
            PreparedStatement pre=this.getCon().prepareStatement(sq1);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Factura fa=new Factura();
                fa.setCodigoFactura(res.getInt("codigoFactura"));
                fa.setNumeroFactura(res.getString("numeroFactura"));
                fa.setCodigoVendedor(res.getInt("codigoVendedor"));
                fa.setCodigoCliente(res.getInt("codigoCliente"));
                fa.setTotalVenta(res.getDouble("totalVenta"));
                fa.setFechaRegitro(res.getString("fechaRegistro"));
                ls.add(fa);
            }
        } 
        catch (Exception e) 
        {
            throw e;
        }finally
        {
            this.desconectar();            
        }
        return ls;
    }
    
    public void AgregarFactura(Factura fa) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="insert into factura (codigoFactura,numeroFactura,codigoVendedor, codigoCliente,totalVenta,estadoDetalles,fechaRegistro) values(null,?,?,?,0.0,0,?);";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1, fa.getNumeroFactura());
            pre.setInt(2, fa.getCodigoVendedor());
            pre.setInt(3, fa.getCodigoCliente());
            pre.setString(4, fa.getFechaRegitro());
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            throw e;
        } 
        finally
        {
            this.desconectar();
        }
    }
        
    public void sumarDetalles(int codigo) throws Exception
    {
        double suma=0.0;
        ResultSet res;
        try 
        {
            this.conectar();
            String sql1="select sum(total) as total from  detalleFactura where codigoFactura=?";
            PreparedStatement pre1=this.getCon().prepareStatement(sql1);
            pre1.setInt(1, codigo);
            res=pre1.executeQuery();
            if (res.next()) 
            {
                suma=res.getDouble("total");
                String sql="";
                PreparedStatement pre;
                if (suma>0.0) 
                {
                    sql="update factura set totalVenta=? where codigoFactura=?;";   
                    pre=this.getCon().prepareStatement(sql);
                    pre.setDouble(1, suma);
                    pre.setInt(2, codigo);
                    pre.executeUpdate();
                    
                    String sql2="UPDATE factura set estadoDetalles = ? where codigoFactura = ?";
                    PreparedStatement pre2=this.getCon().prepareStatement(sql2);
                    pre2.setInt(1, 1);
                    pre2.setInt(2, codigo);
                    pre2.executeUpdate();
                }
                else{
                    this.cambiarEstado(0, codigo);
                    sql="update factura set totalVenta=0.00 where codigoFactura=?;";
                    pre=this.getCon().prepareStatement(sql);
                    pre.setInt(1, codigo);
                    pre.executeUpdate();
                    
                    String sql2="UPDATE factura set estadoDetalles = ? WHERE codigoFactura = ?";
                    PreparedStatement pre2=this.getCon().prepareStatement(sql2);
                    pre2.setInt(1, 0);
                    pre2.setInt(2, codigo);
                    pre2.executeUpdate();
                    
                }                                
                
            }                    
        }
        catch (Exception e) 
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void cambiarEstado(int a, int codigo)throws Exception
    {
        try 
        {
            this.conectar();
            
        } 
        catch (Exception e) 
        {
            throw  e;           
        }
    }
}
