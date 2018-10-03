
package com.modelo;
import com.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ernesto Aviles
 */
public class DaoProducto extends Conexion
{
    public List<Producto> mostrarproductos() throws Exception
    {
        List<Producto> ls=new ArrayList<>();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql="select * from producto;";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Producto pro=new Producto();
                pro.setCodigoProducto(res.getInt("codigoProducto"));
                pro.setNombreProducto(res.getString("nombreaProducto"));
                pro.setPrecioVenta(res.getDouble("precioVenta"));
                pro.setStockMinimo(res.getInt("stockMinimo"));
                pro.setStockAnual(res.getInt("stockAnual"));
                pro.setCodigoBarra(res.getString("codigoBarra"));
                ls.add(pro);
            }            
        } 
        catch (Exception e) 
        {
            throw e;
        }
        finally{
            this.desconectar();
        }
        return ls;
    }
    
     public void insertarProducto(Producto pro) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="insert into producto values(null,?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            //pre.setInt(1, pro.getCodigoProducto());
            pre.setString(1, pro.getNombreProducto());
            pre.setDouble(2, pro.getPrecioVenta());
            pre.setInt(3, pro.getStockMinimo());
            pre.setInt(4, pro.getStockAnual());
            pre.setString(5, pro.getCodigoBarra());
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
     
      public void modificarProducto(Producto pro) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="update producto set nombreaProducto=?, precioVenta=?, stockMinimo=?, stockAnual=?, codigoBarra=? where codigoProducto=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, pro.getNombreProducto());
            pre.setDouble(2, pro.getPrecioVenta());
            pre.setInt(3, pro.getStockMinimo());
            pre.setInt(4, pro.getStockAnual());
            pre.setString(5, pro.getCodigoBarra());
            pre.setInt(6, pro.getCodigoProducto());
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
    public void eliminarProducto(Producto pro) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="delete from producto where codigoProducto=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, pro.getCodigoProducto());
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
}
