
<%@page import="java.util.ArrayList"%>
<%@page import="com.database.DAO.adduserdao"%>
<%@page import="com.web.actions.*"%>
<%@page import="com.login.*"%>
<%@page import="com.database.DAO.adduserdao.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>

<%!String name = "";
	String word = "";

	boolean flag = false;

	StringBuffer sb = null;
	String info = "Opps,Something Went Wrong Try Again..";%>

<%
	sb = new StringBuffer();

	name = request.getParameter("name");
	word = request.getParameter("word");

	String info = "nopassword";

	/* Check User */

	int eventId = adduserdao.getuid(name);

	String ucode = String.valueOf(eventId);

	String pass = adduserdao.getUserSinglePassword(ucode, word);

	if (!pass.equals(null)) {

		sb.append(word + "~" + pass);
	} else {

		sb.append(info);

	}

	System.out.println("Response : ");
	System.out.println(sb.toString());

	out.println(sb.toString()); //Sending Response to Android App
%>
