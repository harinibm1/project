
<%@page import="com.database.DAO.adduserdao"%>
<%@page import="com.actions.*"%>
<%@page import="com.login.*"%>
<%@page import="com.database.DAO.adduserdao.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>

<%!String oldpass = "";
	String newpass = "";
	String loginusr = "";
	String confirmusr = "";

	boolean flag = false;

	StringBuffer sb = null;
	String info = "Opps,Something Went Wrong Try Again..";%>

<%
	sb = new StringBuffer();

oldpass = request.getParameter("CurrentPass");
newpass = request.getParameter("NewPass");
loginusr = request.getParameter("loginUser");



// Status Check //

	String info = "True";
	String info1 = "False";
	String checkall = "Please Enter All The Fields";

	/* Check User */
	
	boolean f = adduserdao.checkCurrentpass(loginusr, oldpass);
	if(f)
	{
		flag = adduserdao.changePass(loginusr, newpass);
		if (flag) {

			sb.append(info);

		} else {

			
		}
		
	}
	else
	{
		sb.append(info1);
	}
	
	

	System.out.println("   Old Pass: " + oldpass);
	System.out.println("  New Password : " + newpass);
	System.out.println("  User: " + loginusr);

	System.out.println("Response : ");
	System.out.println(sb.toString());

	out.println(sb.toString()); //Sending Response to Android App
	
	
	
%>

