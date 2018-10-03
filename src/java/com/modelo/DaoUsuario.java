
package com.modelo;
import java.sql.*;
import com.modelo.DaoUsuario;
import com.conexion.Conexion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lopez
 */
public class DaoUsuario extends Conexion{
    
    public List<Usuario> mostrarUsuario()throws Exception
    {
     List<Usuario> lista=new ArrayList();
     ResultSet res;
        try 
        {
            this.conectar();
            String sql="select * from usuario";
            PreparedStatement pre=getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while(res.next())
            {
              Usuario us=new Usuario();
              us.setCodigoUsuario(res.getInt("codigoUsuario"));
              us.setNombreUsuario(res.getString("nombreUsuario"));
              us.setCodigoRol(res.getInt("codigoRol"));
              us.setPass(res.getString("pass"));
              lista.add(us);
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
    
    public void insertarUsuario(Usuario usu) throws Exception
    {
        Encriptacion en= new  Encriptacion();
        try 
        {
          this.conectar();
          String sql="insert into usuario values(?,?,?,?)";
          PreparedStatement pre=getCon().prepareStatement(sql);
          pre.setInt(1, 0);
          pre.setString(2,usu.getNombreUsuario());
          pre.setString(3,en.encriptar(usu.getPass()));
          pre.setInt(4,usu.getRol().getCodigoRol());
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
    
        public void modificarUsuario(Usuario usu) throws Exception
    {
        try 
        {
          this.conectar();
          String sql="update usuario set nombreUsuario=?,pass=?,codigoRol=? where codigoUsuario=?";
          PreparedStatement pre=getCon().prepareStatement(sql);
          pre.setString(1,usu.getNombreUsuario());
          pre.setString(2,usu.getPass());
          pre.setInt(3,usu.getRol().getCodigoRol());
          pre.setInt(4,usu.getCodigoUsuario());
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
        
    public void eliminarUsuario(Usuario usu) throws Exception
    {
        try 
        {
          this.conectar();
          String sql="delete from usuario where codigoUsuario=?";
          PreparedStatement pre=getCon().prepareStatement(sql);
          pre.setInt(1,usu.getCodigoUsuario());
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
    
    
    public List<Usuario> login(Usuario usuario)throws Exception
    {
       List<Usuario> datosU = new ArrayList<>();
       ResultSet res;
        try 
        {
            this.conectar();
            String sql = "select * from usuario where nombreUsuario=? and pass=?";
            PreparedStatement pre = getCon().prepareStatement(sql);
            pre.setString(1,usuario.getNombreUsuario());
            pre.setString(2,usuario.getPass());
            res = pre.executeQuery();
            while(res.next())
            {
                Usuario usu = new Usuario();
                usu.setCodigoUsuario(res.getInt("codigoUsuario"));
                usu.setNombreUsuario(res.getString("nombreUsuario"));
                usu.setPass(res.getString("pass"));
                Rol rol = new Rol();
                rol.setCodigoRol(res.getInt("codigoRol"));
                usu.setRol(rol);
                datosU.add(usu);
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
       
       return datosU;
    }
    
}
