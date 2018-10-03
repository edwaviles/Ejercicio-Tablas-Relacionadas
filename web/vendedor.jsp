<%-- 
    Document   : vendedor
    Created on : 25-sep-2018, 9:47:20
    Author     : Roxana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.modelo.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="recursos/js/vendedor.js" type="text/javascript"></script>
         <link href="recursos/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="recursos/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="recursos/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="recursos/DataTables/js/datatables.min.js" type="text/javascript"></script>
        <link href="recursos/DataTables/css/datatables.min.css" rel="stylesheet" type="text/css"/> 
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">       
         <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
         <title>Vendedor</title>
        
        <script Languaje="JavaScript">
            function cargar(codigo,DUI,Nombre,Apellidos,TelefonoOficina,TelefonoMovil)
            {
                document.frmVendedor.txtCodigo.value=codigo;
                document.frmVendedor.txtDui.value=DUI;
                document.frmVendedor.txtNombre.value=Nombre;
                document.frmVendedor.txtApellidos.value=Apellidos;
                document.frmVendedor.txtTelOficina.value=TelefonoOficina;
                document.frmVendedor.txtTelMovil.value=TelefonoMovil;
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
        DaoVendedor daoP = new DaoVendedor();
     %>
    <body background="recursos/Imagenes/f03.jpg" style="background-repeat: no-repeat; background-position: center center; background-size: 100%; background-attachment: fixed;">
        <div class="container">
            <div class="row">
                <form action="procesarV" method="POST" name="frmVendedor">
                <div class="col-md-12" style="margin-top: 30px;">
                        <img src="recursos/Imagenes/vendedor.png" style="width: 50px; height: 50px" >
                        <label class="robo" style="font-weight: 300; margin-bottom: 0px; font-size: 35px;">Vendedor</label>
                        <p class="robo" style="font-weight: 300; font-size: 16px; height: 40px;">Gesti&oacute;n  de vendedores</p>
                </div> 
                <div class="clearfix"></div>
                <div class="col-md-12" style="margin-top: 10px;">
                    <table class="mdl-data-table" cellspacing="1" width="100%"><br><br>
                        <div class="form-column col-md-4 col-sm-4 col-xs-4">
                             <div class="form-group required">
                                 <label class="control-label">Codigo:</label>
                                 <input type="text" class="form-control requerido" name="txtCodigo" readonly="readonly">
                             </div>
                        </div>
                        <div class="form-column col-md-4 col-sm-4 col-xs-4">
                             <div class="form-group required">
                                 <label class="control-label">DUI:</label>
                                 <input type="text" name="txtDui" pattern="\d{8}[\-]\d{1}" class="form-control requerido"
                                        title="Ingrese el siguiente formato 00000000-0"  placeholder="00000000-0" required/>
                             </div>
                        </div>
                        <div class="form-column col-md-4 col-sm-4 col-xs-4">
                             <div class="form-group required">
                                 <label class="control-label">Nombre:</label>
                                 <input type="text" class="form-control requerido" name="txtNombre" required>
                             </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="form-column col-md-4 col-sm-4 col-xs-4">
                             <div class="form-group required">
                                 <label class="control-label">Apellidos:</label>
                                 <input type="text" class="form-control requerido" name="txtApellidos" required>
                             </div>
                        </div>
                         <div class="form-column col-md-4 col-sm-4 col-xs-4">
                             <div class="form-group required">
                                 <label class="control-label">Telefono oficina:</label>
                                 <input type="text" name="txtTelOficina" pattern="\d{4}[\]\d{4}" class="form-control requerido"
                                        title="Ingrese el siguiente formato 0000-0000"  placeholder="0000-0000" required/>
                             </div>
                        </div>
                         <div class="form-column col-md-4 col-sm-4 col-xs-4">
                             <div class="form-group required">
                                 <label class="control-label">Telefono Movil:</label>
                                 <input type="text" name="txtTelMovil" pattern="\d{4}[\]\d{4}" class="form-control requerido"
                                        title="Ingrese el siguiente formato 0000-0000"  placeholder="0000-0000" required/>
                             </div>
                         </div>
                    </table>
                </div>
                <div class="clearfix"></div>
                <div class="col-md-12" style="margin-top: 30px;">
                    <div class="form-group" align="left">
                        <div class="form-column col-md-12 col-sm-12 col-xs-12">
                            <button type="submit" name="btnInsertar" class="btn btn-success " style="width:150px; height: 40px;">
                                <i class="glyphicon glyphicon-file"></i> Ingresar</button>
                                
                            <button type="submit" name="btnModificar" class="btn btn-warning " style="width:150px; height: 40px;"
                                    onclick="return confirm('¿Desea modificar el registro?')">
                            <i class="glyphicon glyphicon-edit"></i> Modificar</button> 
                            
                            <button type="submit" name="btnEliminar" class="btn btn-danger " style="width:150px; height: 40px;"
                                    onclick="return confirm('¿Esta seguro de eliminar el registro?')" value="Eliminar">
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
                        <table id="listaVendedores" class="table display table-striped table-bordered">
                        <thead>
                                <th>Codigo</th>
                                <th>DUI</th>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th>Telefono Oficina</th>
                                <th>Telefono Movil</th>
                                <th>Acciones</th>
                        </thead>
                        <tbody>
                            <%
                                List<Vendedor> lista = daoP.mostrarVendedores();
                                for(Vendedor ven:lista)
                                {
                            %>
                            <tr class="active">
                                <td><%=ven.getCodigoVendedor() %></td>
                                <td><%=ven.getDui() %></td>
                                <td><%=ven.getNombre() %></td>
                                <td><%=ven.getApellidos() %></td>
                                <td><%=ven.getTelefonoOficina() %></td>
                                <td><%=ven.getTelefonoMovil() %></td>
                                <td><a href="javascript:cargar(<%=ven.getCodigoVendedor()%>,'<%=ven.getDui() %>','<%=ven.getNombre() %>',
                                       '<%=ven.getApellidos() %>','<%=ven.getTelefonoOficina() %>','<%=ven.getTelefonoMovil() %>')">
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