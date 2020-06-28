<%@page import="com.send.mail.CL_SendMail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
String to=	 request.getParameter("To");

to.replaceAll(" ","");
System.out.println(to);
String subject=	 request.getParameter("subj");
System.out.println(subject);
String text =	 request.getParameter("text");
System.out.println(text);
boolean flag =CL_SendMail.sendPersonalizedMail1(to, "demoprojectmail123@gmail.com", "demo@123", subject, text, "smtp.gmail.com", "465");
System.out.print("Mailsent:"+flag);
out.println(flag);
  %>
 