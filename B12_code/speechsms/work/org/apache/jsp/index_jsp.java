package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.login.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \r\n");
      out.write("<html >\r\n");
      out.write("\r\n");
      out.write("<head >\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"Images/icons.png\" type=\"image/png\" />\r\n");
      out.write("\r\n");
      out.write(" <script src=\"");
      out.print(request.getContextPath());
      out.write("/jquery.toastmessage.js\" type=\"text/javascript\"></script>\r\n");
      out.write("  <link href=\"");
      out.print(request.getContextPath());
      out.write("/jquery.toastmessage.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>SESAME:Secure Your Password</title>\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/CSS/style.css\" media=\"all\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/CSS/style1.css\" media=\"all\" />\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write(".site-name{\r\n");
      out.write("text-shadow: 0 6px 4px #33F, -3px -5px 4px #F00, 3px -5px 4px #0F0;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#burning h1 {\r\n");
      out.write("        color: #fff;\r\n");
      out.write("        text-shadow: 0px -1px 4px white, 0px -2px 10px yellow, 0px -10px 20px #ff8000, 0px -18px 40px red;\r\n");
      out.write("        font: 70px 'BlackJackRegular';\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#anaglyphic h1 {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: 10px auto;\r\n");
      out.write("\tfont-family: Monotype Corsiva;\r\n");
      out.write("\tfont-size: 40px; \r\n");
      out.write("\tcolor: rgba(0,168,255,0.5);\r\n");
      out.write("\ttext-shadow: 1px 1px 0 rgba(255,0,180,0.5);\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/Images/22206.jpg\">\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"page-wrapper\">\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<IMG SRC=\"");
      out.print(request.getContextPath());
      out.write("/Images/title2.png\" width=90% height=\"5%\" BORDER=\"0\" ALT=\"\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- /.section, /#header -->\r\n");
      out.write("<div style=\"position: absolute;top: 220px;left: 50px;width: 400px;height: 400px;\">\r\n");
      out.write("<IMG SRC=\"");
      out.print(request.getContextPath());
      out.write("/Images/cloud-service.png\" width=100% height=\"100%\" BORDER=\"0\" ALT=\"\">\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"footer-wrapper\" >\r\n");
      out.write("\t\t\t\t<div class=\"section\" >\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div id=\"footer-columns\" class=\"clearfix\" >\r\n");
      out.write("\t\t\t\t\t\t<div class=\"region region-footer-firstcolumn\" style=\"position: absolute; top:200px;left: 600px;\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"block-user-login\" class=\"block block-user\" style=\"position: absolute; top:10px;left: 100px;width: 130px;\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<h2><font style=\"color: #FF4500;\"><b>Admin login</b></font></h2>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"content\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/adminloginaction\" method=\"post\" id=\"user-login-form\" ><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"form-item form-type-textfield form-item-name\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"edit-name--2\">Admin Id <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"form-required\" title=\"This field is required.\">*</span></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"edit-name--2\" name=\"name\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tsize=\"15\" maxlength=\"60\" class=\"form-text required\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"form-item form-type-password form-item-pass\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"edit-pass\">Password <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"form-required\" title=\"This field is required.\">*</span></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"password\" id=\"edit-pass\" name=\"pass\" size=\"15\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tmaxlength=\"128\" class=\"form-text required\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"form-actions form-wrapper\" id=\"edit-actions--2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"submit\" id=\"edit-submit--2\" name=\"op\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"Log in\" class=\"form-submit\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- /#footer-columns -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div id=\"footer\" class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"region region-footer\">\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"block-system-powered-by\" class=\"block block-system\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- /#footer -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.section, /#footer-wrapper -->\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /#page, /#page-wrapper -->\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"http://www.tylerfrankenstein.com/sites/default/files/js/js_loJJMZ-yLpCFnc5Htc8xgIMfdfNbw5E30CdocHWSiaM.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write(" \r\n");
	
		int no=Utility.parse(request.getParameter("no"));
System.out.println("No :"+no);
		if(no==1)
		{
      out.write("\r\n");
      out.write("\t\t<div  style=\"position: absolute;top: 550px;left: 500px;color: #8B4513;font-size: 20px;font-family: monotype corsiva; \">\r\n");
      out.write("\t\t<p>Invalid User</p>\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t");
}
		if(no==2)
		{
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div  style=\"position: absolute;top: 550px;left: 500px;color: #8B4513;font-size: 20px; \">\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t $().toastmessage('showErrorToast', \"Opp's,Something went wrong ..!\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</script></div>\t\t\r\n");
      out.write("\t\t");
}
		
		
		if(no==3)
		{
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div  style=\"position: absolute;top: 550px;left: 500px;color: #8B4513;font-size: 20px;font-family: monotype corsiva; \">\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<p>You have Logged Out Successfully!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t\t");

		}
		
		
	
      out.write("\r\n");
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
