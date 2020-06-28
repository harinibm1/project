package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.AES_CBC_encryption_Decryption;
import java.sql.*;
import com.database.DAO.*;

public final class trans_005fdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/CSS/user_table.css\" type=\"text/css\" />\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");

	ResultSet rs = admindao.getTrans();

	System.out.println(" Trans Details,.....!");
	AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/GroupManager\"\tmethod=\"post\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div style=\"position: absolute; left: 60px;\" >\r\n");
      out.write("\t\t\t<table >\r\n");
      out.write("\t\t\t\t<caption>Transaction Details</caption>\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write(" \t\t\t\t\t\t<th>S.NO</th>\r\n");
      out.write("\t\t\t\t\t\t<th>User Code</th>\r\n");
      out.write("\t\t\t\t\t\t<th>User Name</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Domain Name</th>\r\n");
      out.write("\t\t\t\t\t\t<th>User ID</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Password</th>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t");

					if (rs != null)
						while (rs.next()) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getInt(1));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getString(2));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(admindao.getUserName(rs.getString(2)));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getString(3));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getString(5));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(a.decrypt(rs.getString(4)));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
