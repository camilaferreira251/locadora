package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class veiculo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        function gravar(){\n");
      out.write("            document.getElementById(\"action\").value= \"gravar\";\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    <head>\n");
      out.write("    \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <title>Cadastro de Veiculos</title>\n");
      out.write("    </head>\n");
      out.write("        ");
      projetolocadoracarros.dao.VeiculoDAO dao = null;
      synchronized (_jspx_page_context) {
        dao = (projetolocadoracarros.dao.VeiculoDAO) _jspx_page_context.getAttribute("dao", PageContext.PAGE_SCOPE);
        if (dao == null){
          dao = new projetolocadoracarros.dao.VeiculoDAO();
          _jspx_page_context.setAttribute("dao", dao, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("            \n");
      out.write("    <body>\n");
      out.write("        <div align=\"center\">\n");
      out.write("        <h1>Cadastro de Veiculos</h1>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <form action=\"veiculo\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" id=\"action\" name=\"action\" value=\"\" />\n");
      out.write("            <div align=\"center\">\n");
      out.write("                <label id=\"id\"> ID: </label><input id=\"id\" type=\"text\" name=\"id\" size=\"5\">\n");
      out.write("            </div>\n");
      out.write("            <div align=\"center\">\n");
      out.write("                <label id=\"placa\"> Placa: </label><input id=\"placa\" type=\"text\" name=\"placa\" size=\"5\">\n");
      out.write("            </div>\n");
      out.write("            <div align=\"center\">\n");
      out.write("                <label id=\"modelo\"> Modelo: </label><input id=\"modelo\" type=\"text\" name=\"modelo\" size=\"5\">\n");
      out.write("            </div>\n");
      out.write("            <div align=\"center\">\n");
      out.write("                <label id=\"marca\"> Marca: </label><input id=\"marca\" type=\"text\" name=\"marca\" size=\"5\">\n");
      out.write("            </div>\n");
      out.write("            <div align=\"center\">\n");
      out.write("                <label id=\"cor\"> Cor: </label><input id=\"cor\" type=\"text\" name=\"cor\" size=\"5\">\n");
      out.write("            </div>\n");
      out.write("            <div align=\"center\">\n");
      out.write("                <label id=\"arcondicionado\"> Ar condicionado: </label><input id=\"arcondicionado\" name=\"arcondiconado\" type=\"text\" size=\"5\">\n");
      out.write("            </div>\n");
      out.write("            <div align=\"center\">\n");
      out.write("                <label id=\"travaeletrica\"> Trava Elétrica: </label><input id=\"travaeletrica\" name=\"travaeletrica\" type=\"text\" size=\"5\">\n");
      out.write("            </div>\n");
      out.write("           \n");
      out.write("            <br>\n");
      out.write("            <div align=\"center\">\n");
      out.write("                <button id=\"gravar_submit\" onclick=\"grava();\" value=\"Gravar\">Gravar</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
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
