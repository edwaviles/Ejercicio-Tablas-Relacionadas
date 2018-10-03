
package com.conexion;
import java.sql.*;

/**
 *Nombre de la clase: Conexion
 * Version: Ernesto Aviles
 * Fecha: 25/09/2018
 * Copyright: Ernesto Aviles
 * @author Ernesto Aviles
 */
public class Conexion 
{
 Connection con;

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
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facturacion2","root","");
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
           throw e;
        }
    }
    public void desconectar()throws  Exception{
        try 
        {
            if (con!=null) 
            {
                if (!con.isClosed()) 
                {
                    con.close();
                }
            }
        } 
        catch (SQLException e) 
        {
            throw e;
        }
    }
}
