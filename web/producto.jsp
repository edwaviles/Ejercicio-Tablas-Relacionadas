<%-- 
    Document   : producto
    Created on : 25-sep-2018, 9:19:45
    Author     : Roxana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.modelo.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="recursos/js/Producto.js" type="text/javascript"></script>
        <link href="recursos/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="recursos/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="recursos/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="recursos/DataTables/js/datatables.min.js" type="text/javascript"></script>
        <link href="recursos/DataTables/css/datatables.min.css" rel="stylesheet" type="text/css"/> 
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">       
         <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Producto</title>
        
        <script Languaje="JavaScript">
            function cargar(Codigo,Nombre,Precio,StockMinimo,StockAnual,CodigoBarra)
            {
                document.frmProducto.txtCodigo.value=Codigo;
                document.frmProducto.txtNombre.value=Nombre;
                document.frmProducto.txtPrecio.value=Precio;
                document.frmProducto.txtStockM.value=StockMinimo;
                document.frmProducto.txtStockA.value=StockAnual;
                document.frmProducto.txtCodigoBarra.value=CodigoBarra;
            }
        </script>
        <%
            if(request.getAttribute("msj") !=null)
            {
        %>
        <script type="text/javascript">
            alert('<%= request.getAttribute("msj") %>');
        </script>
        <%
            }
        %>
    </head>
     <%
        DaoProducto daoP = new DaoProducto();
     %>     
    <body background="recursos/Imagenes/f03.jpg" style="background-repeat: no-repeat; background-position: center center; background-size: 100%; background-attachment: fixed;">
        <div class="container">
            <div class="row">
                <form action="procesarProducto" method="get" name="frmProducto">
                     <div class="col-md-12" style="margin-top: 30px;">
                        <img src="recursos/Imagenes/pro.png" style="width: 50px; height: 50px" >
                        <label class="robo" style="font-weight: 300; margin-bottom: 0px; font-size: 35px;">Producto</label>
                        <p class="robo" style="font-weight: 300; font-size: 16px; height: 40px;">Gesti&oacute;n  de productos</p>
                </div> 
                <div class="clearfix"></div>
                <div class="col-md-12" style="margin-top: 10px;">
                    <table class="mdl-data-table" cellspacing="1" width="100%"><br><br>
                        <div class="form-column col-md-4 col-sm-4 col-xs-4">
                             <div class="form-group required">
                                 <label class="control-label">Codigo:</label>
                                 <input type="text" class="form-control requerido" name="txtCodigo" readonly="readonly" required>
                             </div>
                        </div>
                        <div class="form-column col-md-4 col-sm-4 col-xs-4">
                             <div class="form-group required">
                                 <label class="control-label">Nombre del producto:</label>
                                 <input type="text" class="form-control requerido" name="txtNombre" required>
                             </div>
                        </div>
                        <div class="form-column col-md-4 col-sm-4 col-xs-4">
                             <div class="form-group required">
                                 <label class="control-label">Precio:</label>
                                 <input type="number" class="form-control requerido" name="txtPrecio" step="any" required>
                             </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="form-column col-md-4 col-sm-4 col-xs-4">
                             <div class="form-group required">
                                 <label class="control-label">Stock Minimo:</label>
                                 <input type="number" name="txtStockM" class="form-control requerido" required/>
                             </div>
                        </div>
                         <div class="form-column col-md-4 col-sm-4 col-xs-4">
                             <div class="form-group required">
                                 <label class="control-label">Stock Anual:</label>
                                 <input type="number" name="txtStockA" class="form-control requerido" required/>
                             </div>
                        </div>
                         <div class="form-column col-md-4 col-sm-4 col-xs-4">
                             <div class="form-group required">
                                 <label class="control-label">Codigo de barra:</label>
                                 <input type="text" name="txtCodigoBarra"  class="form-control requerido" required/>
                             </div>
                         </div>
                    </table>
                </div>
                <div class="col-md-12" style="margin-top: 30px;">
                   <div class="form-group" align="left">
                        <div class="form-column col-md-12 col-sm-12 col-xs-12">
                            <button type="submit" name="btnInsertar" class="btn btn-success " style="width:150px; height: 40px;" value="Ingresar">
                                <i class="glyphicon glyphicon-file"></i> Ingresar</button>
                            <button type="submit" name="btnModificar" class="btn btn-warning " style="width:150px; height: 40px;" value="Modificar"
                                   onclick="return confirm('¿Desea modificar el registro?') ">
                            <i class="glyphicon glyphicon-edit"></i> Modificar</button> 
                            <button type="submit" name="btnEliminar" class="btn btn-danger " style="width:150px; height: 40px;" value="Eliminar"
                                   onclick="return confirm('¿Esta seguro de eliminar el registro?')">
                                    <i class="glyphicon glyphicon-remove"></i> Eliminar</button>
                            <button type="reset" name="btnLimpiar"class="btn btn-primary " style="width:150px; height: 40px;">
                                <i class="glyphicon glyphicon-retweet"></i> Limpiar</button>
                        </div>
                    </div>
                </div>
                </form>
                <div class="clearfix"></div><br><br><br>
                <div class="col-md-12" style="margin-top: 10px;">
                    <div class="table-responsive">
                        <table id="listaProductos" class="table table-hover">
                        <thead>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Stock Minimo</th>
                                <th>Stock Anual</th>
                                <th>Codigo de barra</th>
                        </thead>
                        <tbody>
                            <%
                                List<Producto> lista = daoP.mostrarproductos();
                                for(Producto pro:lista)
                                {
                            %>
                            <tr class="active">
                                <td><%=pro.getCodigoProducto() %></td>
                                <td><%=pro.getNombreProducto()%></td>
                                <td><%=pro.getPrecioVenta() %></td>
                                <td><%=pro.getStockMinimo() %></td>
                                <td><%=pro.getStockAnual() %></td>
                                <td><%=pro.getCodigoBarra() %></td>
                                <td><a href="javascript:cargar(<%=pro.getCodigoProducto()%>,'<%=pro.getNombreProducto()%>','<%=pro.getPrecioVenta() %>',
                                       '<%=pro.getStockMinimo() %>','<%=pro.getStockAnual() %>','<%=pro.getCodigoBarra() %>')">
                                        <input type="submit" class="btn btn-info" value="Seleccionar" required></a></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    </div>
                </div>
            </div>
        </div>	
    </body> 
</html>