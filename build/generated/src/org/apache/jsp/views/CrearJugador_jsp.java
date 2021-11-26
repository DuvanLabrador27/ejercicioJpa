package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CrearJugador_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\" integrity=\"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1 style=\"text-align: center;\">Registro de jugadores</h1>\n");
      out.write("\n");
      out.write("            <form class=\"form-group\" action=\"");
      out.print(request.getContextPath());
      out.write("/ControladorJugador\" method=\"GET\">\n");
      out.write("\n");
      out.write("                <label><b>Tipo Documento</b></label>\n");
      out.write("                <input class=\"form-control\" type=\"text\" name=\"txt_tipoDoc\"  placeholder=\"Ejemplo: CC\" required><br>\n");
      out.write("               \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"exampleFormControlSelect2\">Example multiple select</label>\n");
      out.write("                    <select multiple class=\"form-control\" id=\"exampleFormControlSelect2\">\n");
      out.write("                        <option>1</option>\n");
      out.write("                        <option>2</option>\n");
      out.write("                        <option>3</option>\n");
      out.write("                        <option>4</option>\n");
      out.write("                        <option>5</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <label><b>Numero Documento</b></label>\n");
      out.write("                <input class=\"form-control\" type=\"text\" name=\"txt_doc\"  placeholder=\"Ejemplo: 1004998372\" required><br>\n");
      out.write("\n");
      out.write("                <label><b>Nombre</b></label>\n");
      out.write("                <input class=\"form-control\" type=\"text\" name=\"txt_nombre\"  placeholder=\"Ejemplo: Duvan\" required><br>\n");
      out.write("\n");
      out.write("                <label><b>Apellido</b></label>\n");
      out.write("                <input class=\"form-control\" type=\"text\" name=\"txt_apellido\"  placeholder=\"Ejemplo: Labrador\" required><br>\n");
      out.write("\n");
      out.write("                <label><b>Fecha de nacimiento</b></label>\n");
      out.write("                <input class=\"form-control\" type=\"Date\" name=\"fechaNacimiento\" required><br>\n");
      out.write("\n");
      out.write("                <label><b>Pais de nacimiento</b></label>\n");
      out.write("                <input class=\"form-control\" type=\"text\" name=\"txt_pais\"  placeholder=\"Ejemplo: Colombia\" required><br>\n");
      out.write("\n");
      out.write("                <label><b>Ciudad de nacimiento</b></label>\n");
      out.write("                <input class=\"form-control\" type=\"text\" name=\"txt_ciudad\"  placeholder=\"Ejemplo: Cúcuta\" required><br>\n");
      out.write("\n");
      out.write("                <label><b>Posición de juego</b></label>\n");
      out.write("                <input class=\"form-control\" type=\"text\" name=\"txt_posicion\"  placeholder=\"Ejemplo: Extremo Izquierdo    \" required><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <input type=\"submit\" name=\"accion\" value=\"Crear Jugador\" class=\"btn btn-primary\"/>\n");
      out.write("                <input class=\"btn btn-primary\" type=\"submit\" name=\"accion\" value=\"Volver\" onClick=\"window.location.href = '../index.jsp'\">\n");
      out.write("            </form>\n");
      out.write("        </div> \n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\" integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
