<%-- 
    Document   : Ventas
    Created on : 25-sep-2018, 19:46:55
    Author     : Ernesto Aviles
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
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
        <title>JSP Page</title>
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
        <div class="container">
            <div class="col-md-12" style="margin-top: 30px;">
                        <img src="recursos/Imagenes/fac.png" style="width: 50px; height: 50px" >                        
                        <label class="robo" style="font-weight: 300; margin-bottom: 0px; font-size: 35px;">Facturas</label>
                        <p class="robo" style="font-weight: 300; font-size: 16px; height: 40px;">Gesti&oacute;n  de Facturas</p>
                </div> 
            <div class="clearfix"></div>
            <form name="frmFactura" action="procesarVenta" method="get">
                <div class="row">
                    <div class="form column col-md-4 col-lg-4 col-xs-4">
                        <div class="form-group">
                            <label class="control-label">Codigo:</label></th>
                        <input class="form-control"  type="text" name="codigoF" readonly="readonly">
                        </div>
                    </div>
                     <div class="form column col-md-4 col-lg-4 col-xs-4">
                        <div class="form-group">
                            <label class="control-label">Numero:</label>
                            <input class="form-control" id="NumeroFact" type="text" name="NumeroF">
                        </div>
                    </div>                  
                     <div class="form column col-md-4 col-lg-4 col-xs-4">
                        <div class="form-group">
                            <label class="control-label" >Vendedor:</label>
                            <select class="form-control" name="codVendedor" >
                                <option value="Seleccionar">--Seleccionar--</option>
                                <%
                                    List<Vendedor> lisC=DaoV.mostrarVendedores();
                                    for (Vendedor ven : lisC) {
                                        %>
                                        <option value="<%=ven.getCodigoVendedor()%>"><%=ven.getNombre()%></option>
                                        <%
                                        }
                                    %>                                         
                            </select>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="form column col-md-4 col-lg-4 col-xs-4">
                        <div class="form-group">
                            <label class="control-label">Cliente:</label>
                            <input class="form-control" type="text" id="Nombre_cliente" name="codCliente" list="Cliente" />
                            <datalist  id="Cliente">                                
                                <%
                                    List<Cliente> lis=DaoC.mostrarClientes();
                                    for (Cliente cli : lis) {
                                        %>
                                            <option value="<%=cli.getNombre()%>" label="<%=cli.getCodigoCliente()%>" />
                                        <%
                                        }
                                    %>                                                             
                            </datalist>  
                        </div>
                    </div>                  
                    <!--<div class="form column col-md-4 col-lg-4 col-xs-4">
                        <div class="form-group">
                            <label class="control-label">Fecha:</label>
                            <input type="date" name="FechaR"  class="form-control">
                        </div>
                    </div>-->
                    <!--<div class="form column col-md-4 col-lg-4 col-xs-4">
                        <div class="form-group">
                            <label class="control-label">Total:</label>
                            <input type="number" name="Total" step="any" class="form-control">
                        </div>
                    </div>-->
                                      
                        <div class="form column col-md-2 col-lg-2 col-xs-2">
                            <div class="form-group">
                                <label>  </label>
                                <!--<input class="btn btn-success btn-block" type="submit" id="nuevo" name="btnNuevo" value="Nuevo">-->
                                <button class="btn btn-success btn-block" id="nuevo" name="btnNuevo" onclick="return confirm('Desea agregar la factura')">Nuevo</button>
                            </div>
                        </div>
                        <div class="form column col-md-2 col-lg-2 col-xs-2">
                            <div class="form-group">
                                <label>  </label>
                                <input class="btn btn-primary btn-block" type="submit" name="btnModificar"  value="Modificar">
                            </div>
                        </div>
                        <div class="form column col-md-2 col-lg-2 col-xs-2">
                            <div class="form-group">
                                <label>  </label>
                                <input class="btn btn-danger btn-block" type="submit" name="btnEliminar" value="Eliminar">
                            </div>
                        </div>
                        <div class="form column col-md-2 col-lg-2 col-xs-2">
                            <div class="form-group">
                                <label>  </label>
                                <input class="btn btn-primary btn-block" type="reset    " name="btnLimpiar" value="Limpiar">
                            </div>
                        </div>   
                    </div>                   
                </div>
            </form>             
        </div>
        <hr>
        <div class="container">                                    
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
                        List<Factura> ls=DaoF.mostrarFacturas();
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
                                <button class="btn btn-primary">Seleccionar</button>                                                                    
                                <!--<a href="javascript:cargarNF('')">
                                    <button  class="btn btn-info" data-toggle="modal" data-target="#detalleF" id="verDetalle">                                                                              
                                        Ver detalle
                                    </button>
                                </a>-->    
                                <a href="Ventas.jsp?codigo=<%= fac.getCodigoFactura()%>">
                                    <button  class="btn btn-info" >                                                                              
                                        Ver detalle
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
                
        <!-- The Modal -->
<div class="modal" id="detalleF" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg ">
    <div class="modal-content">        
        <!-- Modal Header -->
        <div class="modal-header">            
            <!--<button type="button" class="close" data-dismiss="modal">&times;</button>-->
            <h4 class="modal-title"><label id="num"></label></h4>
        </div>                    
        <!-- Modal body -->
        <div class="modal-body">
            <table>
                <tr>
                    <th style="width: 35%">
                        <!--<form name="frmDetalle" action="" method="GET">-->
                        <div class="form column col-md-6">
                            <div class="form-group">
                                <label class="control-label">Codigo</label>
                                <input type="text" class="form-control" id="txtCod" name="txtCod" readonly="readonly">
                            </div>
                        </div>
                            <div class="form column col-md-12">
                                <div class="form-group">
                                    <label class="control-label">Producto</label>
                                    <input type="text" class="form-control" id="txtProd" name="txtProd" list="lsProd">
                                    <datalist id="lsProd">
                                        <%
                                            List<Producto> lsPro=DaoP.mostrarproductos();
                                            for (Producto pro : lsPro) 
                                            {
                                            %>
                                            <option value="<%= pro.getCodigoProducto()%>" label="<%= pro.getNombreProducto()%>" />
                                            <%
                                            }
                                            %>                                        
                                    </datalist>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            <div class="form column col-md-12">
                                <div class="form-group">
                                    <label class="control-label">Cantidad</label>
                                    <input type="number" step="any" class="form-control" id="txtCantidad" name="txtCantidad">
                                </div>
                            </div>
                         
                            <div class="clearfix"></div>
                            <div class="form column col-md-3">
                                <div class="form-group">                                    
                                    
                                    <!--<a href="Ventas.jsp?codigo=&accion=add">-->
                                    <button name="btnAgregarD" class="btn-block btn btn-success" 
                                            onclick="
                                                    var prod=document.getElementById('txtProd').value
                                                    var cantidad=document.getElementById('txtCantidad').value                                                    
                                                    var l1='Ventas.jsp?prod=';                                                    
                                                    var l2 = l1.concat(prod,'&cantidad=',cantidad,'&codigo=',
                                                                                                    <%=request.getParameter("codigo")%>,'&accion=','add');
                                                    window.location.href=l2;
                                                    //window.location.href='Ventas.jsp?prod='+document.getElementById('txtProd').value+'';
                                            ">
                                            <span class="glyphicon glyphicon-plus">                                                                                                
                                            </span>
                                        </button>
                                    <!--</a>-->
                                </div>
                            </div>
                            <div class="form column col-md-3">
                                <div class="form-group">                                    
                                    <!--<a href="Ventas.jsp?codigo=&accion=mod">-->
                                        <button name="btnModificarD" class="btn-block btn btn-info"
                                                onclick="
                                                    var prod=document.getElementById('txtProd').value
                                                    var cantidad=document.getElementById('txtCantidad').value
                                                    var codDet=document.getElementById('txtCod').value
                                                    var l1='Ventas.jsp?prod=';                                                    
                                                    var l2 = l1.concat(prod,'&cantidad=',cantidad,'&codD=',codDet,'&codigo=',<%=request.getParameter("codigo")%>,'&accion=','mod');
                                                    window.location.href=l2;
                                                    //window.location.href='Ventas.jsp?prod='+document.getElementById('txtProd').value+'';
                                            ">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    <!--</a>-->
                                </div>
                            </div>
                            <div class="form column col-md-3">
                                <div class="form-group">                                    
                                    <!--<a href="Ventas.jsp?codigo=<%=request.getParameter("codigo")%>&accion=del">%>-->
                                        <button name="btnEliminarD" class="btn-block btn btn-danger"
                                                onclick="
                                                    var prod=document.getElementById('txtProd').value
                                                    var cantidad=document.getElementById('txtCantidad').value
                                                    var codDet=document.getElementById('txtCod').value
                                                    var l1='Ventas.jsp?prod=';                                                    
                                                    var l2 = l1.concat(prod,'&cantidad=',cantidad,'&codD=',codDet,'&codigo=',<%=request.getParameter("codigo")%>,'&accion=','del');
                                                    window.location.href=l2;
                                                ">
                                            <span class="glyphicon glyphicon-minus"></span>
                                        </button>
                                    <!--</a>-->
                                </div>
                            </div>
                            <div class="form column col-md-3">
                                <div class="form-group">                                    
                                    <button name="btnLimpiarD" class="btn-block btn btn-primary"><span class="glyphicon glyphicon-repeat"></span></button>
                                </div>
                            </div>
                        <!--</form>     -->
                    </th>
                    <th style="width: 65%" VALIGN="top">
                        <table class="table table-hover table-responsive" >
                            <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>cod. Producto</th>
                                    <th>cod. barra</th>
                                    <th>Producto</th>
                                    <th>Cantidad</th>   
                                    <th>Precio Venta</th>   
                                    <th>Total</th>  
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>  
                                <%                                                                      
                                    if (request.getParameter("codigo")!=null) 
                                    {
                                        codigo=Integer.parseInt(request.getParameter("codigo"));
                                        %>
                                        <script>
                                            $("#detalleF").modal('show');                                               
                                            document.getElementById('num').innerHTML= "Detalle de factura codigo: "+<%= codigo%>;  
                                            function Cargar(det,prod, cant, precioV, total) 
                                            {
                                                document.getElementById("txtCod").value=det;
                                                document.getElementById("txtProd").value=prod;
                                                document.getElementById("txtCantidad").value=cant;                                                                                            
                                            }
                                        </script>
                                    <%
                                    }                            
                                    try 
                                    {               
                                        List<DetalleFactura> lsDet=DaoD.mostrarDetalle(codigo);
                                        for (DetalleFactura dett : lsDet) 
                                        {                                            
                                    %>    
                                            <tr>                                       
                                                <th><%= dett.getCodigoDetalle()%></th>
                                                <th><%= dett.getCodigoProducto()  %></th>
                                                <th><%= dett.getCodigoBarra()%></th>
                                                <th><%= dett.getNombreProducto()%></th>
                                                <th><%= dett.getCantida()%></th>
                                                <th><%= dett.getPrecioVenta()%></th>
                                                <th><%= dett.getTotal()%></th>   
                                                <th>
                                                    <a href="JavaScript:Cargar('<%=dett.getCodigoDetalle()%>','<%=dett.getCodigoProducto()%>','<%= dett.getCantida()%>','<%= dett.getPrecioVenta()%>','<%= dett.getTotal()%>')">Seleccionar</a>
                                                </th>
                                            </tr>
                                            <%
                                        }
                                    } 
                                    catch (Exception e) 
                                    {              
                                    }                                    
                                %>                                                                
                            </tbody>
                        </table>                         
                    </th>                        
                </tr>
            </table>
        </div>
      <!-- Modal footer -->
      <div class="modal-footer">
          <div class="container-fluid">
                <div class="row">
                    <div class=" form column col-md-10">
                        <div class="form-group">
                            <div class="alert alert-warning">
                                <strong>Nota</strong><small>
              Al cerrar esta ventana con al menos un producto, ya no podra modificar los productos de esta factura
          </small> 
                            </div>
                        </div>
                    </div> 
                    <div class="form column col-md-2">
                        <div class="form-group">
                            <a href="procesarVenta?codigo=<%=codigo%>">
                                <button type="button" class="btn btn-danger">Guardar venta</button>
                            </a>
                        </div>
                    </div>
                </div>
          </div>                       
      </div>

    </div>
  </div>
</div>
</body>
</html>
<%
    try 
    {
        
        String accion=request.getParameter("accion");
         if (accion!=null) 
         {                                
             int prod=Integer.parseInt(request.getParameter("prod").toString());
             int cant=Integer.parseInt(request.getParameter("cantidad").toString());     
             
            if (prod>0 && cant>0) 
            {
                if (accion.equals("add"))
                { 
                    DaoD.preInsertar(prod, cant,codigo);
                    %>
                    <script>
                        window.location.href="Ventas.jsp?codigo=<%=request.getParameter("codigo")%>";
                    </script>
                    <%                           
                }
                if (accion.equals("mod"))
                {
                    int codigoDet=Integer.parseInt(request.getParameter("codD"));                    
                    DaoD.preModificar(prod, cant,codigo,codigoDet);
                    %>
                    <script>
                        window.location.href="Ventas.jsp?codigo=<%=request.getParameter("codigo")%>";
                    </script>
                    <%
                }
                if (accion.equals("del"))
                {
                    int codigoDet=Integer.parseInt(request.getParameter("codD"));                    
                    DaoD.eliminar(codigoDet);
                    %>
                    <script>                       
                        window.location.href="Ventas.jsp?codigo=<%=request.getParameter("codigo")%>";
                    </script>
                    <%                
                } 
            }              
         } 
     } catch (Exception e) {
     }
            
    %>
