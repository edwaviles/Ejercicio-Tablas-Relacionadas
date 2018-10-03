<%-- 
    Document   : ListaFactura
    Created on : 03-oct-2018, 13:11:39
    Author     : Ernesto Aviles
--%>

<%@page import="com.modelo.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="recursos/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="recursos/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="recursos/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="recursos/DataTables/js/datatables.min.js" type="text/javascript"></script>
        <link href="recursos/DataTables/css/datatables.min.css" rel="stylesheet" type="text/css"/>        
        <script src="recursos/js/JsVentas.js" type="text/javascript"></script>
        <script src ="https://unpkg.com/sweetalert/dist/sweetalert.min.js"> </script> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturas</title>
    </head>
    <body>
          <%
            Factura fa= new Factura();
            DetalleFactura det=new DetalleFactura();
            DaoFactura DaoF=new DaoFactura();
            DaoVendedor DaoV=new DaoVendedor();
            DaoCliente DaoC=new DaoCliente();
            DaoDetalle DaoD=new DaoDetalle();
            DaoProducto DaoP=new DaoProducto();
            int codigo=0;              
            %> 
        <div class="container-fluid"> 
            <div class="col-md-12" style="margin-top: 30px;">
                        <img src="recursos/Imagenes/fac.png" style="width: 50px; height: 50px" >                        
                        <label class="robo" style="font-weight: 300; margin-bottom: 0px; font-size: 35px;">Facturas</label>
                        <p class="robo" style="font-weight: 300; font-size: 16px; height: 40px;">Lista de Facturas</p>
            </div> 
            <div class="clearfix"></div>
            <table id="Facturas" class="mdl-data-table table table-responsive">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Numero</th>
                        <th>Vendedor</th>
                        <th>Cliente</th>
                        <th>Fecha</th>
                        <th>Total</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        //cambiar el 1 por el codigo loguiado
                        List<Factura> ls=DaoF.mostrarTodasFacturas(1);
                        for (Factura fac: ls) 
                        {                                
                        %>
                        <tr>
                            <th><%= fac.getCodigoFactura()%></th>
                            <th><%= fac.getNumeroFactura()%></th>                            
                            <% int codV=fac.getCodigoVendedor();
                               int codC=fac.getCodigoCliente();
                            %>
                            <th><%= DaoV.getNombreV(codV)%></th>
                            <th><%= DaoC.getNombreC(codC)%></th>
                            <th><%= fac.getFechaRegitro()%></th>
                            <th><%
                                if (fac.getTotalVenta()==0.0) 
                                {
                                    %>
                                    <div class="bg-danger "><%= fac.getTotalVenta()%></div>
                                    <%
                                }else{
                                    %>
                                        <%=fac.getTotalVenta()%>
                                    <%
                                }
                                %></th>
                            <th>                                                               
                                <a href="ListaFactura.jsp">
                                    <button  class="btn btn-info" >                                                                              
                                        Ver Factura
                                    </button>
                                </a>
                            </th>
                         </tr>  
                        <%
                        }
                    %>                  
                </tbody>
            </table>  
        </div> 
    </body>
</html>
