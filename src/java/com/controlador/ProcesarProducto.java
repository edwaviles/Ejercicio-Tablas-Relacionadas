/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.DaoProducto;
import com.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ernesto Aviles
 */
public class ProcesarProducto extends HttpServlet {

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
        
        Producto pro = new Producto();
        DaoProducto daoP = new DaoProducto();
        RequestDispatcher rd=null;
        String msj="";
        
        try 
        {         
            if(request.getParameter("btnInsertar")!=null)
            {                
                pro.setNombreProducto(request.getParameter("txtNombre"));
                pro.setPrecioVenta(Double.parseDouble(request.getParameter("txtPrecio")));
                pro.setStockMinimo(Integer.parseInt(request.getParameter("txtStockM")));
                pro.setStockAnual(Integer.parseInt(request.getParameter("txtStockA")));
                pro.setCodigoBarra(request.getParameter("txtCodigoBarra"));
                daoP.insertarProducto(pro);
                msj="Datos agregados correctamente";
            }
            if(request.getParameter("btnModificar")!=null)
            {
                pro.setCodigoProducto(Integer.parseInt(request.getParameter("txtCodigo")));
                pro.setNombreProducto(request.getParameter("txtNombre"));
                pro.setPrecioVenta(Double.parseDouble(request.getParameter("txtPrecio")));
                pro.setStockMinimo(Integer.parseInt(request.getParameter("txtStockM")));
                pro.setStockAnual(Integer.parseInt(request.getParameter("txtStockA")));
                pro.setCodigoBarra(request.getParameter("txtCodigoBarra"));
                daoP.modificarProducto(pro);
                msj="Datos modificados correctamente";
            }
            if(request.getParameter("btnEliminar")!=null)
            {
                pro.setCodigoProducto(Integer.parseInt(request.getParameter("txtCodigo")));
                daoP.eliminarProducto(pro);
                msj="Datos eliminados correctamente";
            }
            rd=request.getRequestDispatcher("producto.jsp");
            request.setAttribute("msj", msj);
        }
        catch (Exception e) 
        {
            request.setAttribute("error", e.toString());
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
