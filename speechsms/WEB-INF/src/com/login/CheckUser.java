package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.adduserdao;

public class CheckUser extends HttpServlet
{
	StringBuffer sb = null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		super.doPost(req, resp);
		String fl = null;
		
		PrintWriter out = resp.getWriter();
		String inf = "Valid User";
		String info = "InValid User";
		
		String name = req.getParameter("Name");
		String pass = req.getParameter("Pass");
		String imei = req.getParameter("imei");
		
		
		System.out.println("Name "+name);
		System.out.println("Code "+pass);
		
		
		try 
		{
			 fl = adduserdao.checkUser(name, pass,imei);
			 
			 System.out.println("Status "+fl);
			
			 if(!fl.equals(null))
			 {
				 sb.append(inf+"~");
				 
			 }
			 else
			 {
				 sb.append(info);
			 }
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		
	}

}
