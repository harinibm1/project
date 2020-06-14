
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.adduserdao"%>
<%@page import="com.actions.*"%>
<%@page import="com.login.*"%>
<%@page import="com.DAO.adduserdao.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>

<%!String name = "";
	String pass = "";

	String flag = null;

	StringBuffer sb = null;
	String info = "Opps,Something Went Wrong Try Again..";%>

<%
	sb = new StringBuffer();

	name = request.getParameter("Name");
	pass = request.getParameter("Pass");
	String imei = request.getParameter("imei");

	String info = "Valid User";
	String info1 = "InValid User";

	/* Check User */

	flag = adduserdao.checkUser(name, pass,imei);

	if (!flag.equals(null))
	{

		String vrysts = adduserdao.Verify_status(name);

		System.out.println("  Password : " + vrysts);

		if(vrysts.trim().equals("pending"))
		{
			sb.append(vrysts);
		}
		else
		{





			sb.append(flag);

		}


	} else {
		if(!flag.equals(""))
		{
			sb.append(info1);

		}else
		{
			sb.append(info1);
		}


	}

	System.out.println("  User Name: " + name);
	System.out.println("  Password : " + pass);

	System.out.println("Response : ");
	System.out.println(sb.toString());

	out.println(sb.toString()); //Sending Response to Android App
%>
