package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.login.*;

public final class AdminChangePwd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t");

		//String admin=Utility.parse1(request.getAttribute("admin"));
		int no=Utility.parse(request.getParameter("no"));
		//int id=Utility.parse(request.getParameter("id"));
		String adminid = session.getAttribute("admin_id").toString();
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\t<form id=\"login\" action=\"");
      out.print(request.getContextPath() );
      out.write("/adminchangepwdaction\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"admin\" value=\"");
      out.print(adminid );
      out.write("\"></input>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(adminid );
      out.write("\"></input>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"no\" value=\"2\"></input>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br></br>\r\n");
      out.write("\t<div id=\"a1\" style=\"position: absolute;top: 30px;left: 200px;\">\r\n");
      out.write("\t\r\n");
      out.write("\t <table id=\"login\" align=\"center\">\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t\t<td colspan=\"3\" align=\"center\"><font style=\"font-family:cursive;font-size: 20px;color: black;\"><b>Change Password</b></font></td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td>Admin Id</td>\r\n");
      out.write("\t\t\t     \t\t<td>:</td>\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t<input class=\"field\" type=\"text\" name=\"user_id\" value=\"");
      out.print(adminid );
      out.write("\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t<tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td>Current Password</td>\r\n");
      out.write("\t\t\t     \t\t<td>:</td>\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t<input class=\"field\" type=\"password\" name=\"pass\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t<tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td>New Password </td>\r\n");
      out.write("\t\t\t     \t\t<td>:</td>\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t<input class=\"field\" type=\"password\" name=\"npass\"  required=\"yes\"></input>\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t<tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td>Confirm new password</td>\r\n");
      out.write("\t\t\t     \t\t<td>:</td>\r\n");
      out.write("\t\t\t     \t\t<td><input class=\"field\" type=\"password\" name=\"cpass\"  required=\"yes\"></input></td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t<tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t\t     \t<input type=\"submit\" value=\"Change Pass\" />\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</table></div></form>\r\n");

if(no==1)
{
	
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position: absolute;top: -10px;color:red;font-size: 20px;color: #8B4513;font-family: monotype corsiva;\">\t\r\n");
      out.write("\t\t\t<p>Opp's,your current password is wrong ..!</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");

}
if(no==2)
{
	
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position: absolute;top: -10px;color: red;font-size: 20px;color: #8B4513;font-family: monotype corsiva;\">\t\r\n");
      out.write("\t\t\t<p>Opp's,your new password do not match with confirm password ..!</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");

}
if(no==3)
{
	
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position: absolute;top: -10px;color: red;font-size: 20px;color: #8B4513;font-family: monotype corsiva;\">\t\r\n");
      out.write("\t\t\t<p>Opp's,Seems something went wrong....!</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");

}
if(no==4)
{
	
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position: absolute;top: -10px;color: red;font-size: 20px;color: #8B4513;font-family: monotype corsiva;\">\t\r\n");
      out.write("\t\t\t<p>Your Password Updated Successfully....!</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");

}

      out.write("\t\r\n");
      out.write("\t\r\n");
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
