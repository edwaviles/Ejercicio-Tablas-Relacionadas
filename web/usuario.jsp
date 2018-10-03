<%-- 
    Document   : usuario
    Created on : 26-sep-2018, 14:30:52
    Author     : Lopez
--%>

<%@page import="com.modelo.Usuario"%>
<%@page import="com.modelo.Rol"%>
<%@page import="com.modelo.DaoRol"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.DaoUsuario"%>
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
        <script src="recursos/DataTables/datatables.min.js" type="text/javascript"></script>
        <script src="recursos/DataTables/js/usuario.js" type="text/javascript"></script>
        <title>Usuario</title>
        <script Languaje='JavaScript'>
        function cargar(codigoUsuario,nombreUsuario,pass,codigoRol)
        {
         document.frmUsuario.txtCodigo.value=codigoUsuario;
         document.frmUsuario.txtNombre.value= nombreUsuario;
         document.frmUsuario.txtPass.value=pass;
         document.frmUsuario.NombreRol.value=codigoRol;  
        }
        </script>
        <script>
            
  function  validarFormulario()
  {
   
    var formulario=document.frmUsuario;
    if(formulario.txtPass.value != formulario.txtPass2.value)
    {
       alert("Las contraseñas no coinciden");
       formulario.txtPass.value="";
       formulario.txtPass2.value="";
       formulario.txtPass.focus();
       return false;
    }else
    {
        document.getElementById("alerta").innerHTML="";
    }
      
      
  }
      </script>
 
      <%
          if(request.getAttribute("mensaje")!=null)
      {
          if(request.getAttribute("mensaje").equals("I"))
          {
               out.print("<script>");
               out.print("$(document).ready(function(){");
               out.print("swal ( 'EXITO!!', 'Usuario registrado con exito', 'success' );");
               out.print("});");
               out.print("</script>");
          }
          else if(request.getAttribute("mensaje").equals("M"))
          {
                out.print("<script>");
                out.print("$(document).ready(function(){");
                out.print("swal ( 'EXITO!!', 'Usuario modificado con exito', 'success' );");
                out.print("});");
                out.print("</script>");
          }
          else if(request.getAttribute("mensaje").equals("E"))
          {
                out.print("<script>");
                out.print("$(document).ready(function(){");
                out.print("swal ( 'EXITO!!', 'usuario eliminado con exito', 'success' );");
                out.print("});");
                out.print("</script>");
          }
      }
     %>
    </head>
    <%
    DaoRol daor=new DaoRol();
    DaoUsuario daou=new DaoUsuario();
    %>
    <body style="background-color:buttonface;">
            <div class="container">
            <h3>Registro de usuario</h3><hr><hr>
            <form method="GET" action="procesarUsuario1" name="frmUsuario">
                
            <div class="row" id="infoUsuario">
                <div class="form-column col-md-4 col-xs-4 col-sm-4">
                    <div class="form-group requerid">
                     <input type="hidden" name="txtCodigo" class="form-control">
                    </div>            
                </div> 
                <div class="clearfix"></div>
            <div class="form-column col-md-4 col-sm-4 col-xs-4">
                <div class="form-group requerid">
                     <label class="control-label">Nombre</label>
                     <input type="text" name="txtNombre" class="form-control" required="">
                </div> 
            </div>        
                    <div class="form-column col-md-4 col-xs-4 col-sm-4">
                    <div class="form-group requerid">
                        <label class="control-label">Contraseña</label>
                        <input type="password" name="txtPass" class="form-control" id="txtPass" >
                    </div>            
                </div>
                 <div class="clearfix"></div>
                    <div class="form-column col-md-4 col-xs-4 col-sm-4">
                    <div class="form-group requerid">
                        <label class="control-label">Confirme Contraseña</label>
                        <input type="password" name="txtPass2" class="form-control"  id="txtPass2" >
                    </div>            
                </div> 
            <div class="form-column col-sm-4 col-xs-4 col-md-4">
                  <div class="form-group">
                      <label class="control-label">Tipo de usuario:</label>
                      <select name="NombreRol" class="form-control">
                            <%
                                List<Rol>lstPv=daor.mostrarRol();
                                for (Rol p: lstPv)
                                {
                            %>
                            <option value="<%= p.getCodigoRol()%>"> <%=p.getNombreRol() %></option>
                            <% 
                                }
                            %>
                        </select>
                  </div>
            </div>  
            <div class="clearfix"></div>
            <div class="form-column col-sm-2 col-xs-2 col-md-2">
                <div class="form-group requerid">
                    <input type="submit" name="btnAgregar" value="Agregar" class="btn btn-primary btn-block" onclick="validarFormulario();">
                </div>          
            </div>
            <div class="form-column col-sm-2 col-xs-2 col-md-2">
               <div class="form-group">
                   <input type="submit" name="btnModificar" value="Modificar" class="btn btn-success btn-block"  onclick="return confirm('Desea modificar el usuario?')">
                </div>          
            </div>
            <div class="form-column col-sm-2 col-xs-2 col-md-2"> 
               <div class="form-group requerid">
                   <input type="submit" name="btnEliminar" value="Eliminar" class="btn btn-danger btn-block"  onclick="return confirm('Desea eliminar el usuario?')">
                </div>          
            </div>
            <div class="form-column col-sm-2 col-xs-2 col-md-2">
               <div class="form-group requerid">
                   <input type="reset" name="btnLimpiar" value="Cancelar" class="btn btn-primary btn-block">
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
                        <th><font color="white">Nombre de usuario</font></th>
                        <th><font color="white">Codigo de Rol</font></th>
                        <th><font color="white">Accion</font></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Usuario> lista=daou.mostrarUsuario();
                        for(Usuario cli:lista)
                        {
                    %>
                    <tr>
                        <td><%=cli.getCodigoUsuario() %></td>
                        <td><%=cli.getNombreUsuario() %></td>
                        <td><%= daor.mostrarNombre(cli.getCodigoRol()).getNombreRol()%>
                        <td>
                            <a href="javascript:cargar(<%=cli.getCodigoUsuario()%>,'<%=cli.getNombreUsuario() %>','<%=cli.getPass()%>',<%=cli.getCodigoRol()%>)" >
                            <input type="submit" value="Seleccionar" class="btn btn-success "> 
                            </a>
                        </td>
                    </tr>
                    <%
                        }
                     %>
                </tbody>
            </table>
                <br>
            </div>
        </div>
   
    </body>
</html>
