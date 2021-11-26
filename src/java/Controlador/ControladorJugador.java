/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.CopaAmerica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angie
 */
@WebServlet(name = "ControladorJugador", urlPatterns = {"/ControladorJugador"})
public class ControladorJugador extends HttpServlet {

    String listar = "views/listarJugadores.jsp";
    String listarXequipo = "views/listarJugadoresEquipo.jsp";
    String add = "views/CrearJugador.jsp";
    private CopaAmerica ca;

    public ControladorJugador() {
        ca = new CopaAmerica();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorJugador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorJugador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("listar")) {
            try {
                listar(request, response);
            } catch (Exception ex) {
                System.out.println("Error Listar!");
            }
        } else if (action.equalsIgnoreCase("crear")) {
            try {
                listarEquipos(request, response);
            } catch (Exception ex) {
                System.out.println("Error Crear!");
            }
        } else if (action.equalsIgnoreCase("Crear Jugador")) {
            try {
                crear(request, response);
            } catch (Exception ex) {
                System.out.println("Error Crear!");
            }
        } else if (action.equalsIgnoreCase("listarXequipo")) {
            try {
                listaXequipo(request, response);
            } catch (Exception ex) {
                System.out.println("Error Crear!");
            }
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("jugadores", ca.getJugadores());
        response.sendRedirect(listar);
    }

    public void listarEquipos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("equipos", ca.getEquipos());
        response.sendRedirect(add);
    }

    public void listaXequipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codigoEquipo"));
        request.getSession().setAttribute("jugadoresXequipo", ca.getJugadoresEquipo(id));
        response.sendRedirect(listarXequipo);
    }

    public void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoDoc = request.getParameter("txt_tipoDoc");
        String numeroDoc = request.getParameter("txt_doc");
        String nombre = request.getParameter("txt_nombre");
        String apellido = request.getParameter("txt_apellido");
        String fecha = request.getParameter("fechaNacimiento");
        String pais = request.getParameter("txt_pais");
        String ciudad = request.getParameter("txt_ciudad");
        String posicion = request.getParameter("txt_posicion");
        int select_equipo = Integer.parseInt(request.getParameter("select_equipo"));
        System.out.println(fecha);
        ca.registrarJugador(tipoDocumento(tipoDoc), numeroDoc, nombre, apellido, fecha, pais, ciudad, posicion, select_equipo);
        listar(request, response);
    }

    public String tipoDocumento(String id) {
        String str;
        switch (id) {
            case "0":
                str = "CEDULA CIUDADANIA";
                break;
            case "1":
                str = "TARJETA IDENTIDAD";
                break;
            case "2":
                str = "CEDULA EXTRANJERIA";
                break;
            default:
                str = "PASAPORTE";
                break;
        }
        return str;
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
