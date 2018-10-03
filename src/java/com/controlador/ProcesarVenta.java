/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.DaoCliente;
import com.modelo.DaoDetalle;
import com.modelo.DaoFactura;
import com.modelo.Factura;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
/**
 *
 * @author Ernesto Aviles
 */
public class ProcesarVenta extends HttpServlet {

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
            throws ServletException, IOException,Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Factura fa=new Factura();
        DaoFactura daoF=new DaoFactura();
        DaoCliente daoC=new DaoCliente();
        DaoDetalle DaoD=new DaoDetalle();
        try 
        {
            
            if (request.getParameter("codigo")!=null) 
            {
                if (Integer.parseInt(request.getParameter("codigo"))>0) {
                    daoF.sumarDetalles(Integer.parseInt(request.getParameter("codigo")));                    
                    response.sendRedirect("Ventas.jsp");
                }                
            }
            if (request.getParameter("btnNuevo")!=null) 
            {
                fa.setCodigoFactura(0);
                fa.setNumeroFactura(request.getParameter("NumeroF"));
                fa.setCodigoVendedor(Integer.parseInt(request.getParameter("codVendedor")));
                fa.setCodigoCliente(daoC.getidC(request.getParameter("codCliente")));
                fa.setTotalVenta(0.0);
                Date fecha= new Date();            
                fa.setFechaRegitro(new SimpleDateFormat("dd-MM-yyyy").format(fecha));
                daoF.AgregarFactura(fa);                
                response.sendRedirect("Ventas.jsp?codigo="+DaoD.getCodFact(fa.getNumeroFactura(), fa.getCodigoCliente()));
            }
            response.sendRedirect("Ventas.jsp?codigo="+fa.getCodigoFactura());
        } 
        catch (Exception e) 
        {
            throw e;
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProcesarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProcesarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
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
