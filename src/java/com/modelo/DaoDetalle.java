package com.modelo;

import com.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ernesto Aviles
 */
public class DaoDetalle  extends Conexion{
    
    
    public List<DetalleFactura> mostrarDetalle(int codigo) throws Exception
    {
        ResultSet res;
        List<DetalleFactura> ls=new ArrayList();
        try 
        {
            this.conectar();
            String sql="select * from detallefactura where codigoFactura=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, codigo);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                DetalleFactura det=new DetalleFactura();
                det.setCodigoDetalle(res.getInt("codigoDetalle"));
                det.setCodigoFactura(res.getInt("codigoFactura"));
                det.setCodigoProducto(res.getInt("codigoProducto"));
                det.setCodigoBarra(res.getString("codigoBarra"));
                det.setNombreProducto(res.getString("nombreProducto"));
                det.setCantida(res.getInt("cantidad"));
                det.setPrecioVenta(res.getDouble("precioVenta"));
                det.setTotal(res.getDouble("total"));
                ls.add(det);
            }
        } 
        catch (SQLException e) 
        {
            throw e;
        }
        return  ls;
    }
    
    public void preInsertar(int prod, int cant, int codF)throws Exception
    {
        DetalleFactura det=new DetalleFactura();
        det.setCodigoFactura(codF);
        det.setCodigoProducto(prod);        
        det.setCantida(cant);                        
        det.setCodigoBarra(this.getcodigoBarra(prod));
        det.setNombreProducto(this.getNombre(prod));        
        det.setPrecioVenta(this.getPV(prod));
        det.setTotal(det.getCantida()*det.getPrecioVenta());
        this.insertar(det);
    }
    
    public void preModificar(int prod, int cant, int codF,int codDet)throws Exception
    {        
        DetalleFactura deta=new DetalleFactura();
        deta.setCodigoDetalle(codDet);
        deta.setCodigoFactura(codF);
        deta.setCodigoProducto(prod);        
        deta.setCantida(cant);                        
        deta.setCodigoBarra(this.getcodigoBarra(prod));
        deta.setNombreProducto(this.getNombre(prod));        
        deta.setPrecioVenta(this.getPV(prod));
        deta.setTotal(deta.getCantida()*deta.getPrecioVenta());
        this.modificar(deta);
    }
    
    public String getcodigoBarra(int cod) throws Exception
    {
        ResultSet res;
        String codigo="";
        try 
        {
            this.conectar();
            //String  sql="select codigoBarra, nombreProducto, precioVenta from producto where codigoProducto = ?";
            String  sql="select codigoBarra from producto where codigoProducto = ?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, cod);
            res=pre.executeQuery();
            while (res.next()) 
            {      
                codigo=res.getString("codigoBarra");
                //ls.add(res.getString("nombreaProducto"));
                //ls.add(res.getInt("precioVenta"));
            }
        } 
        catch (Exception e) 
        {
            throw  e;
        }
        finally
        {
           this.desconectar();
        }
        return  codigo;
    }
    
     public String getNombre(int cod) throws Exception
    {
        ResultSet res;
        String nombre="";
        try 
        {
            this.conectar();
            //String  sql="select codigoBarra, , precioVenta from producto where codigoProducto = ?";
            String  sql="select nombreaProducto from producto where codigoProducto = ?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, cod);
            res=pre.executeQuery();
            while (res.next()) 
            {      
               nombre=res.getString("nombreaProducto");
                //ls.add(res.getInt("precioVenta"));
            }
        } 
        catch (Exception e) 
        {
            throw  e;
        }
        finally
        {
           this.desconectar();
        }
        return  nombre;
    }
     
      public double getPV(int cod) throws Exception
    {
        ResultSet res;
        double pv=0.0;
        try 
        {
            this.conectar();
            //String  sql="select codigoBarra, , precioVenta from producto where codigoProducto = ?";
            String  sql="select precioVenta from producto where codigoProducto = ?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, cod);
            res=pre.executeQuery();
            while (res.next()) 
            {      
               pv=res.getDouble("precioVenta");
                //ls.add(res.getInt("precioVenta"));
            }
        } 
        catch (Exception e) 
        {
            throw  e;
        }
        finally
        {
           this.desconectar();
        }
        return  pv;
    }
     
    public void insertar(DetalleFactura det)throws Exception
    {
        try 
        {
            this.conectar();
            String sql="insert into detalleFactura values(null,?,?,?,?,?,?,?);";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, det.getCodigoFactura());
            pre.setInt(2, det.getCodigoProducto());
            pre.setString(3, det.getCodigoBarra());
            pre.setString(4, det.getNombreProducto());
            pre.setInt(5, det.getCantida());
            pre.setDouble(6, det.getPrecioVenta()); 
            pre.setDouble(7, det.getTotal());
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
    
    public void modificar(DetalleFactura det)throws Exception
    {
        try 
        {
            this.conectar();
            String sql="update detalleFactura set codigoProducto=?, codigoBarra=?, nombreProducto=?, cantidad=?,"
                    + "precioVenta=?, total=? where codigoDetalle=?;";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, det.getCodigoProducto());
            pre.setString(2, det.getCodigoBarra());
            pre.setString(3, det.getNombreProducto());
            pre.setInt(4, det.getCantida());
            pre.setDouble(5, det.getPrecioVenta()); 
            pre.setDouble(6, det.getTotal());
            pre.setInt(7, det.getCodigoDetalle());
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
    
    public void  eliminar(int codigo)throws Exception
    {
        try 
        {
            this.conectar();
            String sql="delete from detalleFactura where codigoDetalle=?;";
            PreparedStatement pre=this.getCon().prepareStatement(sql);            
            pre.setInt(1, codigo);
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
    
    public int getCodFact(String codF, int codClien) throws Exception
    {
        ResultSet res;
        int codigo=0;
        try 
        {
            this.conectar();            
            String  sql="select codigoFactura from factura where numeroFactura=? and codigoCliente=?;";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1, codF);
            pre.setInt(2, codClien);
            res=pre.executeQuery();
            while (res.next()) 
            {      
               codigo=res.getInt("codigoFactura");
            }
        } 
        catch (Exception e) 
        {
            throw  e;
        }
        finally
        {
           this.desconectar();
        }
        return  codigo;
    }
    
    
}
