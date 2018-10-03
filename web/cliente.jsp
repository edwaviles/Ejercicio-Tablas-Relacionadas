<%-- 
    Document   : cliente
    Created on : 24-sep-2018, 21:36:42
    Author     : Lopez
--%>
<%@page import="java.util.*" %>
<%@page import="com.modelo.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="recursos/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="recursos/DataTables/css/datatables.min.css" rel="stylesheet" type="text/css"/>   
        <script src="recursos/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <link href="recursos/Alertas/css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <script src="recursos/Alertas/js/sweetalert.min.js" type="text/javascript"></script>
        <script src="recursos/DataTables/datatables.min.js" type="text/javascript"></script>
        <script src="recursos/DataTables/js/newjavascript.js" type="text/javascript"></script> 
        <title>CRUD CLIENTE</title>
        <script Languaje='JavaScript'>
            function cargar(codigoCliente,nombre,apellidos,direccion)
            {
               document.frmCliente.txtCodigo.value= codigoCliente;
               document.frmCliente.txtNombre.value= nombre;
               document.frmCliente.txtApellido.value= apellidos;
               document.frmCliente.txtDireccion.value= direccion;        
            }
        </script>
        <%
          if(request.getAttribute("mensaje")!=null)
      {
          if(request.getAttribute("mensaje").equals("I"))
          {
               out.print("<script>");
               out.print("$(document).ready(function(){");
               out.print("swal ( 'EXITO!!', 'Cliente registrado con exito', 'success' );");
               out.print("});");
               out.print("</script>");
          }
          else if(request.getAttribute("mensaje").equals("M"))
          {
                out.print("<script>");
                out.print("$(document).ready(function(){");
                out.print("swal ( 'EXITO!!', 'Cliente modificado con exito', 'success' );");
                out.print("});");
                out.print("</script>");
          }
          else if(request.getAttribute("mensaje").equals("E"))
          {
                out.print("<script>");
                out.print("$(document).ready(function(){");
                out.print("swal ( 'EXITO!!', 'Cliente eliminado con exito', 'success' );");
                out.print("});");
                out.print("</script>");
          }
      }
     %>
         
         
    </head>
    <%
    DaoCliente daoc=new DaoCliente();    
    %>
    <body style="background-color:buttonface;">
        <div class="container">
            <h3>Registro de clientes</h3><hr><hr>
            <form method="get" action="procesarCliente" name="frmCliente">
            <div class="row" id="infoCliente">
                <div class="form-column col-md-4 col-xs-4 col-sm-4">
                    <div class="form-group requerid">
                        <label class="control-label">Codigo</label>
                        <input type="number" name="txtCodigo" class="form-control" required="">
                    </div>            
                </div>      
            <div class="form-column col-md-4 col-sm-4 col-xs-4">
                <div class="form-group requerid">
                     <label class="control-label">Nombre</label>
                     <input type="text" name="txtNombre" class="form-control" required="">
                </div>         
            </div>
            <div class="clearfix"></div>
            <div class="form-column col-sm-4 col-xs-4 col-md-4">
                  <div class="form-group">
                      <label class="control-label">Apellidos</label>
                      <input type="text" name="txtApellido" class="form-control" required="">
                  </div>
            </div>
            <div class="form-column col-sm-4 col-xs-4 col-md-4">
                <div class="form-group">
                    <label class="control-label">Direcion</label>
                    <textarea class="form-control" name="txtDireccion" required=""></textarea>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="form-column col-sm-2 col-xs-2 col-md-2">
                <div class="form-group requerid">
                    <input type="submit" name="btnAgregar" value="Agregar" class="btn btn-primary btn-block">
                </div>          
            </div>
            <div class="form-column col-sm-2 col-xs-2 col-md-2">
               <div class="form-group requerid">
                   <input type="submit" name="btnModificar" value="Modificar" class="btn btn-success btn-block" onclick="return confirm('Desea modificar el usuario?')">
                </div>          
            </div>
            <div class="form-column col-sm-2 col-xs-2 col-md-2">
               <div class="form-group requerid">
                   <input type="submit" name="btnEliminar" value="Eliminar" class="btn btn-danger btn-block" onclick="return confirm('Desea eliminar el usuario?')">
                </div>          
            </div>
            <div class="form-column col-sm-2 col-xs-2 col-md-2">
               <div class="form-group requerid">
                   <input type="reset" name="btnLimpiar" value="Cancelar"  class="btn btn-primary btn-block">
                </div>          
            </div>
            </div>
            </form>
         </div>
        <div class="container">
            <hr>
            <center><h4>Clientes Registrados</h4></center>
            <hr>
            <br>
            <div class="form-column col-md-12 co-xs-12 co-sm-12" style="margin-top: 10px; background: rgba(255,255,255,0.7); border-radius: 5%">
             
            <table class="mdl-data-table" id="tabla" cellspacing="1" width="100%">
                <thead bgcolor="#424242">
                    <tr>
                        <th><font color="white">Codigo</font></th>
                        <th><font color="white">Nombre</font></th>
                        <th><font color="white">Direccion</font></th>
                        <th><font color="white">Telefono</font></th>
                        <th><font color="white">Accion</font></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Cliente> lista=daoc.mostrarClientes();
                        for(Cliente cli:lista)
                        {
                    %>
                    <tr>
                        <td><%=cli.getCodigoCliente()%></td>
                        <td><%=cli.getNombre()%></td>
                        <td><%=cli.getApellido()%></td>
                        <td><%=cli.getDireccion() %></td>
                        <td>
                            <a href="javascript:cargar(<%=cli.getCodigoCliente()%>,'<%=cli.getNombre()%>','<%=cli.getApellido()%>','<%=cli.getDireccion()%>')" >
                            <input type="submit" value="Seleccionar" class="btn btn-success "> 
                            </a>
                        </td>
                    </tr>
                    <%
                        }
Cliente ec =new Cliente();

                     %>
                </tbody>
            </table>
                <br>
            </div>
        </div>
    </body>
</html>
