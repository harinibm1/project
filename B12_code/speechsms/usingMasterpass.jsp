
<%@page import="com.util.AES_CBC_encryption_Decryption"%>
<%@page import="com.database.DAO.adduserdao"%>
<%@page import="com.web.actions.*"%>
<%@page import="com.login.*"%>
<%@page import="com.database.DAO.adduserdao.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>

<%!String mastpass = "";
	String uid = "";
	String upass = "";
	

	boolean flag = false;

	StringBuffer sb = null;
	String info = "Opps,Something Went Wrong Try Again..";%>

<%
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
	
	
	
%>

