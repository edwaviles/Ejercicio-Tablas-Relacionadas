
package com.modelo;

import com.modelo.DaoRol;
import com.modelo.DaoUsuario;
import com.modelo.Rol;
import com.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lopez
 */
public class ProcesarUsuario1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd=null;
        DaoUsuario daou=new DaoUsuario();
        Usuario us=new Usuario();
        DaoRol daor=new DaoRol();
        Rol ro=new Rol();
        String mensaje=null;
        try 
        {      
            if(request.getParameter("btnAgregar") !=null)
            {
                us.setNombreUsuario(request.getParameter("txtNombre"));
                us.setPass(request.getParameter("txtPass"));
                ro.setCodigoRol(Integer.parseInt(request.getParameter("NombreRol")));
                us.setRol(ro);
                daou.insertarUsuario(us);
                mensaje="I";
                
            }
            else if(request.getParameter("btnModificar") !=null)
            {
                us.setNombreUsuario(request.getParameter("txtNombre"));
                us.setPass(request.getParameter("txtPass"));
                ro.setCodigoRol(Integer.parseInt(request.getParameter("NombreRol")));
                us.setRol(ro);
                 us.setCodigoUsuario(Integer.parseInt(request.getParameter("txtCodigo")));
                daou.modificarUsuario(us);
                mensaje="M";
                
            }
            else if(request.getParameter("btnEliminar") !=null)
            {
            us.setCodigoUsuario(Integer.parseInt(request.getParameter("txtCodigo")));
            daou.eliminarUsuario(us);
            mensaje="E";
            
            }
            
            rd=request.getRequestDispatcher("usuario.jsp");
            request.setAttribute("mensaje",mensaje);
            rd.forward(request, response);
        }
        catch (Exception e)
        {
            request.setAttribute("Error aqui", e.toString());
            
        }
        
        
        
        
        if(request.getParameter("key")!=null)
        {
            DaoUsuario daous = new DaoUsuario();
            Usuario usuario = new Usuario();
        try 
        {
            usuario.setNombreUsuario(request.getParameter("username"));
            usuario.setPass(request.getParameter("password"));
            List<Usuario> datosU=daou.login(usuario);
            usuario = (Usuario)datosU.get(0);
            if(usuario.getCodigoUsuario()!=0 )
            {
                out.print(1);
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuario",usuario);
            }
            else
            {
                out.print(0);
            }
        }
        catch (Exception e)
        {
            out.print("Error dao: "+e);
        }
        }
  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
