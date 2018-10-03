
$(document).ready(function ()
{
    $('#alerta').hide();
});


$(document).on('click','#btnEnviar',function ()
{   
  if(validar())
  {
      var username = $('#username').val();
      var password =$('#password').val();
      $.ajax({
          url: 'controladorUsuario',
          type:'post',
          data: {'username':username,'password':password},
          success: function (data)
          {
              if(data==1)
              {
                  alert();
              }
              else
              {
                  $("#alerta").attr("class","alert alert-danger");
                  $("#texto").html("Usuario o contraseña incorrecto");
                  $("#alerta").slideDown(1500);
                  $("#alerta").slideUp(2500);
              }
          }
      });
  }
  else
  {
      $("#alerta").attr("class","alert alert-danger");
      $("#texto").html("Todos los campos son obligatorios");
      $("#alerta").slideDown(1500);
      $("#alerta").slideUp(2500);
  }
});


function validar()
{
    var bandera=true;
    $.each($(".requerido"),function ()
    {       
        if($(this).val()=='')
        {
           bandera=false;
        }
    });
    return bandera;
}