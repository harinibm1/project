package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.database.DAO.adduserdao;
import com.actions.*;
import com.login.*;
import com.database.DAO.adduserdao.*;
import java.util.*;
import java.sql.*;

public final class getuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

String name = "";
	String pass = "";

	boolean flag = false;

	StringBuffer sb = null;
	String info = "Opps,Something Went Wrong Try Again..";
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	sb = new StringBuffer();

	name = request.getParameter("Name");
	
	String info = "Valid User";
	String info1 = "InValid User";

	/* Get Spot Information */

	String userid = request.getParameter("Userid");
		StringBuffer  sb = new StringBuffer();
		String userinfo = "";
		ArrayList<String> list = adduserdao.getUserinfo(userid);
		
		System.out.println("Get Spot Information ");
		for(int i = 0;i<list.size();i++)
		{
			userinfo = list.get(i);
			sb.append(userinfo+"~");
			System.out.println("Spot Val ??? "+userinfo);
		}
		
		
	System.out.println("   User Name: " + name);
	

	System.out.println("Response : ");
	System.out.println(sb.toString());

	out.println(sb.toString()); //Sending Response to Android App

      out.write("\r\n");
      out.write("\r\n");
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
