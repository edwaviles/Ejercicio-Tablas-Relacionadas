/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ernesto Aviles
 */
public class DaoCliente extends Conexion
{
    public List<Cliente> mostrarClientes() throws Exception
    {
        ResultSet res;
        List<Cliente> ls=new ArrayList();
        try 
        {
            this.conectar();
            String sq1="select * from cliente;";
            PreparedStatement pre=this.getCon().prepareStatement(sq1);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Cliente cli=new Cliente();
                cli.setCodigoCliente(res.getInt("codigoCliente"));  
                cli.setNombre(res.getString("nombre"));
                cli.setApellido(res.getString("apellidos"));
                cli.setDireccion(res.getString("direccion"));                
                ls.add(cli);
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
    
    
    public String getNombreC(int id) throws Exception{
        String nombre=" -  ";
        ResultSet res;
        try 
        {
            this.conectar();
            String sql="select nombre from cliente where codigoCliente=?;";            
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, id);
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
     public int getidC(String nombre) throws Exception{
        int id=0;
        ResultSet res;
        try 
        {
            this.conectar();
            String sql="select codigoCliente from cliente where nombre = ?;";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1, nombre);
            res=pre.executeQuery();
            if (res.next()) 
            {                
                id=res.getInt("codigoCliente");
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
       return id;
    }
     
     
     
public void insertarCliente(Cliente cli) throws Exception
{
    try 
    {
        this.conectar();
         String sql="insert into cliente values(?,?,?,?)";
         PreparedStatement pre=getCon().prepareStatement(sql);
         pre.setInt(1,cli.getCodigoCliente());
         pre.setString(2,cli.getNombre());
         pre.setString(3,cli.getApellido());
         pre.setString(4,cli.getDireccion());
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

public void modificarCliente(Cliente cli) throws Exception
{
    try 
    { 
         this.conectar();
         String sql="update cliente set nombre=?,apellidos=?,direccion=?where codigoCliente=?";
         PreparedStatement pre=getCon().prepareStatement(sql);
         pre.setString(1,cli.getNombre());
         pre.setString(2,cli.getApellido());
         pre.setString(3,cli.getDireccion());
         pre.setInt(4,cli.getCodigoCliente());
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

public void eliminarCliente(Cliente cli) throws Exception
{
    try 
    {
         this.conectar();
         String sql="delete from cliente where codigoCliente=?";
         PreparedStatement pre=this.getCon().prepareStatement(sql);
         pre.setInt(1,cli.getCodigoCliente());
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
