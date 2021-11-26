<%-- 
    Document   : CrearJugador
    Created on : 25-nov-2021, 18:58:26
    Author     : Duvan
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.DTO.Equipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Jugadores</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center;">Registro de jugadores</h1>

            <form class="form-group" action="<%=request.getContextPath()%>/ControladorJugador" method="GET">

                <div class="form-group">
                    <label for="exampleFormControlSelect1">Tipo Documento</label>
                    <select class="form-control" id="exampleFormControlSelect1" name="txt_tipoDoc">
                        <option value="0">CEDULA CIUDADANIA</option>
                        <option value="1">TARJETA IDENTIDAD</option>
                        <option value="2">CEDULA EXTRANJERIA</option>
                        <option value="3">PASAPORTE</option>
                    </select>
                </div>

                <label><b>Numero Documento</b></label>
                <input class="form-control" type="text" name="txt_doc"  placeholder="Ejemplo: 1004998372" required><br>

                <label><b>Nombre</b></label>
                <input class="form-control" type="text" name="txt_nombre"  placeholder="Ejemplo: Duvan" required><br>

                <label><b>Apellido</b></label>
                <input class="form-control" type="text" name="txt_apellido"  placeholder="Ejemplo: Labrador" required><br>

                <label><b>Fecha de Nacimiento</b></label>
                <input class="form-control" type="Date" name="fechaNacimiento" required><br>

                <label><b>Pais de Nacimiento</b></label>
                <input class="form-control" type="text" name="txt_pais"  placeholder="Ejemplo: Colombia" required><br>

                <label><b>Ciudad de nacimiento</b></label>
                <input class="form-control" type="text" name="txt_ciudad"  placeholder="Ejemplo: Cúcuta" required><br>

                <label><b>Posición de juego</b></label>
                <input class="form-control" type="text" name="txt_posicion"  placeholder="Ejemplo: Extremo Izquierdo    " required><br>


                <div class="form-group">
                    <label for="exampleFormControlSelect2">Equipo</label>
                    <select class="form-control" id="exampleFormControlSelect2" name="select_equipo">
                        <%
                            List<Equipo> list = (List<Equipo>) request.getSession().getAttribute("equipos");
                            for (Equipo e : list) {
                        %>
                        <option value="<%=e.getCodigo()%>"><%=e.getNombre()%></option>
                        <%}%>
                    </select>
                </div>

                <input type="submit" name="action" value="Crear Jugador" class="btn btn-primary"/>
                <input class="btn btn-primary" type="submit" name="accion" value="Volver" onClick="window.location.href = '../index.jsp'">
            </form>
        </div> 
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
