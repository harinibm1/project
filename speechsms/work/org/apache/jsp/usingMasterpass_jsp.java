package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.AES_CBC_encryption_Decryption;
import com.database.DAO.adduserdao;
import com.actions.*;
import com.login.*;
import com.database.DAO.adduserdao.*;
import java.sql.*;

public final class usingMasterpass_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

String mastpass = "";
	String uid = "";
	String upass = "";
	

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

mastpass = request.getParameter("MastPass");
uid = request.getParameter("uid");
upass = request.getParameter("upass");




// Status Check //

	String info = "True";
	String info1 = "False";
	String checkall = "Please Enter All The Fields";

	
	
	

	System.out.println("   Master Pass: " + mastpass);
	System.out.println("   user id : " + uid);
	System.out.println("   user Pass: " + upass);
	
	
	AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();
	
	
	String b=a.encrypt(mastpass.trim());
	System.out.println("enc Msg :"+b);
	
	flag = adduserdao.checkMastpass(uid,upass,b);
	
	System.out.println("Response : ");
	if(flag)
	{
		sb.append(info);
		System.out.println("true flage blocke :"+info);
	}else
	{
		sb.append(info1);	
		System.out.println("false flage blocke");
	}

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
