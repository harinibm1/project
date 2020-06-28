package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.AES_CBC_encryption_Decryption;
import java.sql.*;
import com.database.DAO.*;
import com.login.*;

public final class user_005fdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/CSS/user_table.css\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");

AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();





	ResultSet rs=admindao.getUser();

System.out.println(" User Details,.....!");

      out.write("\r\n");
      out.write("<body >\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath() );
      out.write("\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div style=\"position: absolute;left: 70px;\">\r\n");
      out.write("\t<table>\r\n");
      out.write("\t<caption>User Details</caption>\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th colspan=\"1\" align=\"center\">Code</th>\r\n");
      out.write("\t\t<th colspan=\"1\" align=\"center\">Id</th>\r\n");
      out.write("\t\t<th colspan=\"1\" align=\"center\">Password</th>\r\n");
      out.write("\t\t<th colspan=\"1\" align=\"center\">Master Password</th>\r\n");
      out.write("\t\t<th colspan=\"1\" align=\"center\">Name</th>\r\n");
      out.write("\t\t<th colspan=\"1\" align=\"center\">Mobile</th>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<th colspan=\"1\" align=\"center\">Delete</th>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</tr></thead>\r\n");
      out.write("\t");

	if(rs!=null)
		while(rs.next())
		{
      out.write("\r\n");
      out.write("\t\t <tbody>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getInt(1) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getString(2) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getString(3)  );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(a.decrypt(rs.getString(6).trim())  );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getString(4) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getString(7) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<td><a href=\"");
      out.print(request.getContextPath());
      out.write("/EditUser?submit=Delete&chk=");
      out.print(rs.getInt(1) );
      out.write("\"><font style=\"color: blue;\">Delete</font></a></td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</tr></tbody>\r\n");
      out.write("\t\t");
}
	
      out.write("\r\n");
      out.write("</table></div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\t");
	
		int no=Utility.parse(request.getParameter("no"));
System.out.println("No :"+no);
		if(no==1)
		{
      out.write("\r\n");
      out.write("\t\t<div  style=\"position: absolute;top: -10px;left: 50px;color: #8B4513;font-size: 20px;font-family: monotype corsiva; \">\r\n");
      out.write("\t\t<p>User Details Updated Successfully..</p>\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t");
}
		if(no==2)
		{
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div  style=\"position: absolute;top: -10px;left: 50px;color: #8B4513;font-size: 20px; \">\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<p>User Deleted Successfully</p>\t\r\n");
      out.write("\t\t</div>\t\t\r\n");
      out.write("\t\t");
}
		
		
	
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
