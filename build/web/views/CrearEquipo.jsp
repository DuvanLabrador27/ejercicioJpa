<%-- 
    Document   : CrearEquipo
    Created on : 25-nov-2021, 17:06:50
    Author     : Angie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Equipos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center;">Registro de equipos</h1>

            <form class="form-group" action="<%=request.getContextPath()%>/ControladorEquipo" method="GET">
                <!-- <label><b>Id</b></label>
                   <input class="form-control" type="text" name="txt_id"  placeholder="Ejemplo: 1" required><br> -->

                <label><b>Nombre</b></label>
                <input class="form-control" type="text" name="txt_nombre"  placeholder="Ejemplo: Barcelona" required><br>

                <label><b>Tecnico</b></label>
                <input class="form-control" type="text" name="txt_tecnico"  placeholder="Ejemplo: Duvan" required><br>

                <input type="submit" name="action" value="Crear Equipo" class="btn btn-primary"/>
                <input class="btn btn-primary" type="submit" name="accion" value="Volver" onClick="window.location.href = '../index.jsp'">
          
            </form>
        </div> 

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</body>
</html>
