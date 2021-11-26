<%-- 
    Document   : index
    Created on : 25-nov-2021, 16:25:27
    Author     : Duvan
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.DTO.Equipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
</html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/carrusel.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:ital,wght@0,700;1,300&display=swap" rel="stylesheet">
        <title>Gestion de equipos</title>
    </head>
    <body>
        <main class="main col">
            <div class="row justify-content-center align-content-center text-center">
                <h1 class="title-1">Bienvenido a la App Web Gestión de Equipos</h1>
            </div>
            <div id="caja-1" class="row">
                <div class="columna col-lg-6">

                    <div  class="mx-auto mt-2 ">
                        <h2>Listado Equipos: </h2> 
                        <ol>

                            <li><a href="views/CrearEquipo.jsp">Agregar Equipos</a></li>
                            <li><a href="<%=request.getContextPath()%>/ControladorEquipo?action=listar">Ver equipos registrados</a></li>

                        </ol>
                    </div>



                </div>
                <div class="columna col-lg-6">

                    <div class="mx-auto mt-2">
                        <h2>Listado Jugadores: </h2>
                        <ol >
                            <li><a  href="<%=request.getContextPath()%>/ControladorJugador?action=crear">Agregar Jugadores</a></li>
                            <li><a href="<%=request.getContextPath()%>/ControladorJugador?action=listar">Ver Jugadores registrados</a></li>

                        </ol>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <div id="carouselExampleDark" class="carousel carousel-dark slide w-100" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="3" aria-label="Slide 4"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="4" aria-label="Slide 5"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active" data-bs-interval="2000">
                                <img src="./imagenes/barcelona.jpg" alt="" class="d-block w-400px mx-auto">
                            </div>



                            <div class="carousel-item" data-bs-interval="2000">
                                <img src="./imagenes/RealMadrid.jpg" alt="" class="d-block w-400px mx-auto">
                            </div>
                            <div class="carousel-item " data-bs-interval="2000">
                                <img src="./imagenes/city.jpg" alt="" class="d-block w-400px mx-auto">
                            </div>

                            <div class="carousel-item" data-bs-interval="2000">
                                <img src="./imagenes/bayern.jpg" alt="" class="d-block w-400px mx-auto">
                            </div>

                            <div class="carousel-item" data-bs-interval="2000">
                                <img src="./imagenes/psg.jpg" alt="" class="d-block w-400px mx-auto">
                            </div>

                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span >Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span >Next</span>
                        </button><br>
                    </div><br>
                </div>

            </div>


        </main>
        <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/646c794df3.js"></script>
        <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>

        <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
    </body>
</html>