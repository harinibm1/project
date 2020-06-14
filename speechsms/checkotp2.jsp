
<%@page import="com.dhs.DAO.adduserdao"%>
<%@page import="com.actions.*"%>
<%@page import="com.login.*"%>
<%@page import="com.dhs.DAO.adduserdao.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>

<%!String onetp = "";
	String pass = "";
	String imei = "";
	String userid = "";

	boolean flag = false;

	StringBuffer sb = null;
	String info = "Opps,Something Went Wrong Try Again..";%>

<%
	sb = new StringBuffer();

onetp = request.getParameter("OTP");
imei = request.getParameter("imei");
userid = request.getParameter("userid");
	
	
	String info = "Valid User";
	String info1 = "InValid User";

	/* Check User */

	flag =true;// adduserdao.checkOTP(onetp);
	
	if (flag) 
	{
		boolean flg = adduserdao.update_loginstatus2(onetp,imei,userid);
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

