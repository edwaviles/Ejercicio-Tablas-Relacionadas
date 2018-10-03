
package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lopez
 */
public class DaoRol extends Conexion{
    
    
    public List<Rol> mostrarRol()throws Exception
    {
     List<Rol> lista=new ArrayList();
     ResultSet res;
        try 
        {
            this.conectar();
            String sql="select * from rol";
            PreparedStatement pre=getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while(res.next())
            {
              Rol r=new Rol();
              r.setCodigoRol(res.getInt("codigoRol"));
              r.setNombreRol(res.getString("tipoRol"));
              lista.add(r);
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
        return lista;
    }
    
        public Rol mostrarNombre(int rol) throws Exception
     {
        Rol ro= new Rol();
        ResultSet res=null;
        try 
        {
              this.conectar();
              String sql = "select * from rol where codigoRol = ?;";
              PreparedStatement pre = this.getCon().prepareStatement(sql);
              pre.setInt(1, rol);   
              res = pre.executeQuery();
             while (res.next()) 
               {              
                   ro.setCodigoRol(res.getInt("codigoRol"));
                   ro.setNombreRol(res.getString("tipoRol"));                
               }
           } catch (SQLException e) 
           {
               throw e;
           }  
           finally 
           {
               this.desconectar();
           }
           return ro;
    }
    
}
