<%@page import="com.util.AES_CBC_encryption_Decryption"%>
<%@page import="com.database.DAO.adduserdao"%>
<%@page import="com.actions.*"%>
<%@page import="com.login.*"%>
<%@page import="com.database.DAO.adduserdao.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>

<%!String uid = "";
	String mastpass = "";

	boolean flag = false;

	StringBuffer sb = null;%>

<%
	sb = new StringBuffer();

	uid = request.getParameter("uid");
	System.out.println("  uid in mast_changepass is >>>>>>>>>>>>>>>>>>>: " + uid);
	mastpass = request.getParameter("mastpass");
	System.out.println("   mastpass in mast_changepass is >>>>>>>>>>>>>>>>>>>: " + mastpass);
	// Status Check //

	String info = "True";
	String info1 = "False";
	String checkall = "Please Enter All The Fields";

	/* Check User */
	
	AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();
		
		
		String b=a.encrypt(mastpass);

	flag = adduserdao.changeMastPass(uid, b);
	if (flag) {

		sb.append(info);

	} else {

		sb.append(info1);
	}

	System.out.println("   uid: " + uid);
	System.out.println("  New Password : " + mastpass);

	System.out.println("Response : ");
	System.out.println(sb.toString());

	out.println(sb.toString()); //Sending Response to Android App
%>

