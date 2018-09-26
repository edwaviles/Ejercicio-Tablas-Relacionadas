
package com.conexion;
import  java.sql.*;

/**
 * Nombre de la clase: Conexion
 * Version: 1
 * Fecha:25/09/2018
 * Copyrigth: Ernesto Aviles
 * @author Ernesto Aviles
 */
public class Conexion {
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void conectar() throws Exception
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facturacion","root","");
        }
        catch (ClassNotFoundException | SQLException e) 
        {
            throw e;
        }
    }
    
    public void desconectar()
    {
        try 
        {
            if(con!=null)
            {
                if(con.isClosed()==false)
                {
                    con.close();
                }
            }
        }
        catch (Exception e) 
        {
            
        }
    } 
}
