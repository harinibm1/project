
<%@page import="com.util.AES_CBC_encryption_Decryption"%>
<%@page import="com.database.DAO.adduserdao"%>
<%@page import="com.actions.*"%>
<%@page import="com.login.*"%>
<%@page import="com.database.DAO.adduserdao.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>

<%!String dname = "";
	String uid = "";
	String upass = "";
	String userlogin="";
	

	boolean flag = false;

	StringBuffer sb = null;
	String info = "Opps,Something Went Wrong Try Again..";%>

<%
	sb = new StringBuffer();

dname = request.getParameter("dname");
uid = request.getParameter("userid");
upass = request.getParameter("pass");





int eventId = adduserdao.getuid(userlogin);

String ucode = String.valueOf(eventId);


// Status Check //

	String info = "True";
	String info1 = "False";
	String checkall = "Please Enter All The Fields";

	
	
	

	System.out.println("   Master Pass: " + dname);
	System.out.println("   user id : " + uid);
	System.out.println("   user Pass: " + upass);
	
	
	AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();
	
	
	String b=a.encrypt(upass.trim());
	System.out.println("enc Msg :"+b);
	
	flag = adduserdao.deletePasswords(dname,b,uid);
	
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

