
<%@page import="com.DAO.adduserdao"%>
<%@page import="com.actions.*"%>
<%@page import="com.login.*"%>
<%@page import="com.DAO.adduserdao.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>

<%!String onetp = "";
	String pass = "";

	boolean flag = false;

	StringBuffer sb = null;
	String info = "Something Went Wrong Try Again..";%>

<%
	sb = new StringBuffer();

onetp = request.getParameter("OTP");


	String info = "Valid User";
	String info1 = "InValid User";

	/* Check User */

	flag = adduserdao.checkOTP(onetp);

	if (flag)
	{
		boolean flg = adduserdao.update_loginstatus(onetp);
		System.out.println("  Verify Status : " + flg);
		sb.append(info);

	} else {

		sb.append(info1);
	}

	System.out.println("  One Time Pass: " + onetp);


	System.out.println("Response : ");
	System.out.println(sb.toString());

	out.println(sb.toString()); //Sending Response to Android App
%>
