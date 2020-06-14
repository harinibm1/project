
<%@page import="com.util.AES_CBC_encryption_Decryption"%>
<%@page import="com.DAO.adduserdao"%>
<%@page import="com.login.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>

<%!String id = "";
	String pass = "",mastpass="",name="",phone="",phone2="",imei="";

	boolean flag = false;

	StringBuffer sb = null;
	String info = "True";
	String info1 = "False";

	%>


<%
	sb = new StringBuffer();

	id = request.getParameter("Id");
	pass = request.getParameter("Pass");
	name = request.getParameter("Name");
	mastpass = request.getParameter("mastpass");

	phone = request.getParameter("Mobile");
	phone2 = request.getParameter("Mobile2");
	imei = request.getParameter("imei");
	String onetp = RandomValue.otpValue();
	System.out.println("  Data is: " + id+"."+pass+"."+name+"."+"."+phone+"."+onetp);



	boolean idexist = adduserdao.checkUserId(id);

	System.out.println("  idexist is: " + idexist);
	if(idexist)
	{

		 sb.append("UserExist");
	}
	else
	{

		AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();


		String b=a.encrypt(mastpass);
	   boolean val =adduserdao.adduser(id,pass,name,b,phone,onetp,"pending",phone2,imei);










		  if(val)
		  {
		  sb.append(info+"~"+onetp);


		  }
		  else
		  {
			  sb.append(info1);
		  }


	
	System.out.println("  Status is: " + sb.toString());
	}

	out.println(sb.toString());
%>
