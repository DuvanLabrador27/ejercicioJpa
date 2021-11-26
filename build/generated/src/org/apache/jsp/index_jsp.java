package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Modelo.DTO.Equipo;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("</html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/carrusel.css\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:ital,wght@0,700;1,300&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <title>Gestion de equipos</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <main class=\"main col\">\n");
      out.write("            <div class=\"row justify-content-center align-content-center text-center\">\n");
      out.write("                <h1 class=\"title-1\">Bienvenido a la App Web Gestión de Equipos</h1>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"caja-1\" class=\"row\">\n");
      out.write("                <div class=\"columna col-lg-6\">\n");
      out.write("\n");
      out.write("                    <div  class=\"mx-auto mt-2 \">\n");
      out.write("                        <h2>Listado Equipos: </h2> \n");
      out.write("                        <ol>\n");
      out.write("\n");
      out.write("                            <li><a href=\"views/CrearEquipo.jsp\">Agregar Equipos</a></li>\n");
      out.write("                            <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/ControladorEquipo?action=listar\">Ver equipos registrados</a></li>\n");
      out.write("\n");
      out.write("                        </ol>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"columna col-lg-6\">\n");
      out.write("\n");
      out.write("                    <div class=\"mx-auto mt-2\">\n");
      out.write("                        <h2>Listado Jugadores: </h2>\n");
      out.write("                        <ol >\n");
      out.write("                            <li><a  href=\"");
      out.print(request.getContextPath());
      out.write("/ControladorJugador?action=crear\">Agregar Jugadores</a></li>\n");
      out.write("                            <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/ControladorJugador?action=listar\">Ver Jugadores registrados</a></li>\n");
      out.write("\n");
      out.write("                        </ol>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col\">\n");
      out.write("                    <div id=\"carouselExampleDark\" class=\"carousel carousel-dark slide w-100\" data-bs-ride=\"carousel\">\n");
      out.write("                        <div class=\"carousel-indicators\">\n");
      out.write("                            <button type=\"button\" data-bs-target=\"#carouselExampleDark\" data-bs-slide-to=\"0\" class=\"active\" aria-current=\"true\" aria-label=\"Slide 1\"></button>\n");
      out.write("                            <button type=\"button\" data-bs-target=\"#carouselExampleDark\" data-bs-slide-to=\"1\" aria-label=\"Slide 2\"></button>\n");
      out.write("                            <button type=\"button\" data-bs-target=\"#carouselExampleDark\" data-bs-slide-to=\"2\" aria-label=\"Slide 3\"></button>\n");
      out.write("                            <button type=\"button\" data-bs-target=\"#carouselExampleDark\" data-bs-slide-to=\"3\" aria-label=\"Slide 4\"></button>\n");
      out.write("                            <button type=\"button\" data-bs-target=\"#carouselExampleDark\" data-bs-slide-to=\"4\" aria-label=\"Slide 5\"></button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"carousel-inner\">\n");
      out.write("                            <div class=\"carousel-item active\" data-bs-interval=\"2000\">\n");
      out.write("                                <img src=\"./imagenes/barcelona.jpg\" alt=\"\" class=\"d-block w-400px mx-auto\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"carousel-item\" data-bs-interval=\"2000\">\n");
      out.write("                                <img src=\"./imagenes/RealMadrid.jpg\" alt=\"\" class=\"d-block w-400px mx-auto\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"carousel-item \" data-bs-interval=\"2000\">\n");
      out.write("                                <img src=\"./imagenes/city.jpg\" alt=\"\" class=\"d-block w-400px mx-auto\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"carousel-item\" data-bs-interval=\"2000\">\n");
      out.write("                                <img src=\"./imagenes/bayern.jpg\" alt=\"\" class=\"d-block w-400px mx-auto\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"carousel-item\" data-bs-interval=\"2000\">\n");
      out.write("                                <img src=\"./imagenes/psg.jpg\" alt=\"\" class=\"d-block w-400px mx-auto\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <button class=\"carousel-control-prev\" type=\"button\" data-bs-target=\"#carouselExampleDark\" data-bs-slide=\"prev\">\n");
      out.write("                            <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                            <span >Previous</span>\n");
      out.write("                        </button>\n");
      out.write("                        <button class=\"carousel-control-next\" type=\"button\" data-bs-target=\"#carouselExampleDark\" data-bs-slide=\"next\">\n");
      out.write("                            <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                            <span >Next</span>\n");
      out.write("                        </button><br>\n");
      out.write("                    </div><br>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </main>\n");
      out.write("        <script\n");
      out.write("            src=\"https://code.jquery.com/jquery-3.6.0.js\"\n");
      out.write("            integrity=\"sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://kit.fontawesome.com/646c794df3.js\"></script>\n");
      out.write("        <script src=\"https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"http://code.jquery.com/jquery.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\" integrity=\"sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js\" integrity=\"sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
