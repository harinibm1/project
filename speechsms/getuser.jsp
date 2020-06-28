
<%@page import="com.database.DAO.adduserdao"%>
<%@page import="com.web.actions.*"%>
<%@page import="com.login.*"%>
<%@page import="com.database.DAO.adduserdao.*"%>
<%@page import="java.util.*"  %>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>

<%!String name = "";
	String pass = "";

	boolean flag = false;

	StringBuffer sb = null;
	String info = "Opps,Something Went Wrong Try Again..";%>

<%
	sb = new StringBuffer();

	name = request.getParameter("Name");
	
	String info = "Valid User";
	String info1 = "InValid User";

	/* Get Spot Information */

	String userid = request.getParameter("Userid");
		StringBuffer  sb = new StringBuffer();
		String userinfo = "";
		ArrayList<String> list = adduserdao.getUserinfo(userid);
		
		System.out.println("Get Spot Information ");
		for(int i = 0;i<list.size();i++)
		{
			userinfo = list.get(i);
			sb.append(userinfo+"~");
			System.out.println("Spot Val ??? "+userinfo);
		}
		
		
	System.out.println("   User Name: " + name);
	

	System.out.println("Response : ");
	System.out.println(sb.toString());

	out.println(sb.toString()); //Sending Response to Android App
%>

