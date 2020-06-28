package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminhome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML+RDFa 1.0//EN\"\r\n");
      out.write("  \"http://www.w3.org/MarkUp/DTD/xhtml-rdfa-1.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\"\r\n");
      out.write("\tversion=\"XHTML+RDFa 1.0\" dir=\"ltr\"\r\n");
      out.write("\t>\r\n");
      out.write("\r\n");
      out.write("<head profile=\"http://www.w3.org/1999/xhtml/vocab\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\r\n");
      out.write("<meta about=\"/create-android-emulator-sd-card-and-write-data-to-it\"\r\n");
      out.write("\tproperty=\"sioc:num_replies\" content=\"1\" datatype=\"xsd:integer\" />\r\n");
      out.write("\t\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"");
      out.print(request.getContextPath());
      out.write("/Images/icons.png\" type=\"image/png\" />\r\n");
      out.write("\r\n");
      out.write("<meta content=\"Create an Android Emulator SD Card and Write Data To It\"\r\n");
      out.write("\tabout=\"/create-android-emulator-sd-card-and-write-data-to-it\"\r\n");
      out.write("\tproperty=\"dc:title\" />\r\n");
      out.write("<link rel=\"shortlink\" href=\"/node/3\" />\r\n");
      out.write("<meta name=\"Generator\" content=\"Drupal 7 (http://drupal.org)\" />\r\n");
      out.write("<link rel=\"canonical\" href=\"/create-android-emulator-sd-card-and-write-data-to-it\" />\r\n");
      out.write("\t\r\n");
      out.write("<title>Mobile Offload</title>\r\n");
      out.write("\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"CSS/style.css\" \tmedia=\"all\" />\r\n");
      out.write("\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" \thref=\"CSS/style1.css\" \tmedia=\"all\" />\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("#anaglyphic h1 {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: 10px auto;\r\n");
      out.write("\tfont-family: Tahoma;\r\n");
      out.write("\tfont-size: 30px; \r\n");
      out.write("\tcolor: #000;\r\n");
      out.write("\ttext-shadow: 3px 3px 0 #fff;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");

String name =session.getAttribute("admin_name").toString();
String adminid = session.getAttribute("admin_id").toString();

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"page-wrapper\">\r\n");
      out.write("\t\t<div id=\"page\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"header\" class=\"without-secondary-menu\">\r\n");
      out.write("\t\t\t\t<div class=\"section clearfix\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<a  title=\"Home\" rel=\"home\" id=\"logo\">\r\n");
      out.write("\t\t\t\t\t <img src=\"Images/icons.png\" alt=\"Home\" />\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div id=\"name-and-slogan\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<IMG SRC=\"");
      out.print(request.getContextPath());
      out.write("/Images/title2.png\" width=90% height=\"5%\" BORDER=\"0\" ALT=\"\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- /#name-and-slogan -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"region region-header\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"block-block-2\" class=\"block block-block\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div  style=\"position: absolute;top: 120px;left: 720px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\tWelcome, <font style=\"color:#5E2612;font-family: monotype corsiva;font-size: 20px;\">");
      out.print(name );
      out.write("</font>&nbsp;<a href=\"");
      out.print(request.getContextPath());
      out.write("/Signout.jsp\" \ttitle=\"logout\"><font style=\"font-size: 15px;\"> LogOut</font></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"main-menu\" class=\"navigation\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<ul id=\"main-menu-links\" class=\"links clearfix\">\r\n");
      out.write("\t\t\t\t<li class=\"menu-533 first\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/adminhome.jsp\" title=\"Home\">Home</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"menu-412\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/user_details.jsp\" title=\"User Details\" target=\"home\">User Details</a></li>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<li class=\"menu-534\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/trans_details.jsp\" title=\"Transaction Details\" target=\"home\">User Password Details</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"menu-480 last\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/adminchangepwdaction?name=");
      out.print(adminid);
      out.write("&no=1&id=");
      out.print(adminid );
      out.write("\" title=\"Change Password\" target=\"home\">Change Password</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"position: absolute;top: 200px;background-color: #8B8989;width: 800px;height: 450px;left: 100px;\" >\r\n");
      out.write("\t\t\t<iframe style=\"position: absolute;top: 20px;width: 700px;height: 400px;left: 50px;\" name=\"home\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</iframe>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
