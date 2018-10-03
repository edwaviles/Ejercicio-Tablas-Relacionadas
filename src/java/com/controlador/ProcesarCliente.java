/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Cliente;
import com.modelo.DaoCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lopez
 */
public class ProcesarCliente extends HttpServlet {

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
        Cliente c=new Cliente();
        DaoCliente daoc =new DaoCliente();
        String mensaje=null;
         
        try 
        {
          c.setCodigoCliente(Integer.parseInt(request.getParameter("txtCodigo")));
          c.setNombre(request.getParameter("txtNombre"));
          c.setApellido(request.getParameter("txtApellido"));
          c.setDireccion(request.getParameter("txtDireccion"));
           
          if(request.getParameter("btnAgregar") !=null)
          {
             daoc.insertarCliente(c);
             mensaje="I";
        
          }else if(request.getParameter("btnEliminar")!=null)
          {  
             daoc.eliminarCliente(c);
             mensaje="E";
          }
          else if(request.getParameter("btnModificar") !=null)
          {      
            daoc.modificarCliente(c);  
          mensaje="M";
          }
        rd=request.getRequestDispatcher("cliente.jsp");
        request.setAttribute("mensaje",mensaje);
        }
         catch (Exception e)
        {
            request.setAttribute("error aqui! ", e.toString());
        }
        rd.forward(request, response);
   
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
