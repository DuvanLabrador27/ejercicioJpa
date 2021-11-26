<%-- 
    Document   : listarJugadores
    Created on : 25-nov-2021, 18:58:38
    Author     : Duvan
--%>

<%@page import="Modelo.DTO.Jugador"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"
            />
        <link
            rel="stylesheet"
            href=" https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css"
            />
        <title>Jugadores Registrados</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">

                <main class="main col">
                    <h1 class="mb-3 justify-content-center text-center">Jugadores Registrados</h1>
                    <a class="btn btn-success mb-3 ml-5" href="<%=request.getContextPath()%>/ControladorJugador?action=crear">Crear Jugador</a>
                    <div class="row justify-content-center  text-center">
                        <div class="columna col-lg-9">
                            <div id="contenido-2">

                                <table

                                    id="tabla-1"
                                    class="table table-striped table-bordered mt-2"
                                    style="width: 100%"
                                    >
                                    <thead>
                                        <tr>
                                            <th>Tipo Documento</th>
                                            <th>Numero Documento</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Fecha de nacimiento</th>
                                            <th>Pais de nacimiento</th>
                                            <th>Ciudad de nacimiento</th>
                                            <th>Posicion de juego</th>
                                            <th>Equipo</th>
                                        </tr>
                                    </thead>
                                    <%
                                        List<Jugador> list = (List<Jugador>) request.getSession().getAttribute("jugadores");
                                        for (Jugador e : list) {
                                    %>
                                    <tbody>
                                        <tr>
                                            <td><%= e.getTipoDocumento()%></td>
                                            <td><%= e.getNumeroDocumento()%></td>
                                            <td><%= e.getNombre()%></td>
                                            <td><%= e.getApellido()%></td>
                                            <td><%= e.getFechaNacimiento()%></td>
                                            <td><%= e.getPaisNacimiento()%></td>
                                            <td><%= e.getCiudadNacimiento()%></td>
                                            <td><%= e.getPosicionJuego()%></td>
                                            <td><%= e.getEquipoCodigo().getNombre()%></td>
                                            <%}%>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <a class="btn btn-success mb-3 ml-5" href="../index.jsp">Volver al home</a>

                </main>
            </div>
        </div>
        <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
        <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>
        <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/646c794df3.js"></script>
        <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>
        <script>
            $(document).ready(function () {
                $("#tabla-1").DataTable();
            });
        </script>
    </body>
</html>