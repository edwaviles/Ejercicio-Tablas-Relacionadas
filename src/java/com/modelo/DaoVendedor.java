
package com.modelo;
import java.sql.*;

import com.conexion.Conexion;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clas: DaoVendedor
 * Version:1.0
 * Fecha:25/09/18
 * CopyRight: MenjivarAlas
 * @author Roxana Menjivar
 */

public class DaoVendedor extends Conexion{
    public List<Vendedor> mostrarVendedores() throws Exception
    {
        ResultSet res;
        List<Vendedor> ls=new ArrayList();
        try 
        {
            this.conectar();
            String sq1="select * from vendedor;";
            PreparedStatement pre=this.getCon().prepareStatement(sq1);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Vendedor ve=new Vendedor();
                ve.setCodigoVendedor(res.getInt("codigoVendedor"));  
                ve.setDui(res.getString("dui"));
                ve.setNombre(res.getString("nombre"));
                ve.setApellidos(res.getString("apellidos"));
                ve.setTelefonoOficina(res.getString("telefonoOficina"));                
                ve.setTelefonoMovil(res.getString("telefonoMovil"));                
                ls.add(ve);
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
    
    
    public String getNombreV(int id) throws Exception{
        String nombre=" -  ";
        ResultSet res;
        try 
        {
            this.conectar();
            String sql="select nombre from vendedor;";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            if (res.next()) 
            {                
                nombre=res.getString("nombre");
            }else{
                nombre="Desconocido";
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
        return nombre;
    }
    
    public void insertarVendedor(Vendedor ven) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="insert into vendedor values(null,?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            //pre.setInt(1, ven.getCodigoVendedor());
            pre.setString(1, ven.getDui());
            pre.setString(2, ven.getNombre());
            pre.setString(3, ven.getApellidos());
            pre.setString(4, ven.getTelefonoOficina());
            pre.setString(5, ven.getTelefonoMovil());
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
    
    public void modificarVendedor(Vendedor ven) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="update vendedor set dui=?, nombre=?, apellidos=?, telefonoOficina=?, telefonoMovil=? where codigoVendedor=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, ven.getDui());
            pre.setString(2, ven.getNombre());
            pre.setString(3, ven.getApellidos());
            pre.setString(4, ven.getTelefonoOficina());
            pre.setString(5, ven.getTelefonoMovil());
            pre.setInt(6, ven.getCodigoVendedor());
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
    
    public void eliminarVendedor(int codigo) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="delete from vendedor where codigoVendedor=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
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
}
