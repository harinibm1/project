package com.web.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DAO.adduserdao;
import com.util.AES_CBC_encryption_Decryption;


@SuppressWarnings("serial")
public class ViewPasswords extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		ResultSet rs = null;
		int ucode =0,qnNo=0;
		String passName;
		String info = "Opps,No Passwords Found !!!!!";
		String output="",passsDetails="",username="",password="";
	
		
		try
		{
			String userid = request.getParameter("Userid");
			
			ucode = adduserdao.getuid(userid);
			String ucode1=String.valueOf(ucode);
			rs = adduserdao.getUserPasswords(ucode1);
			
			StringBuffer sb = new StringBuffer();
			  AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();
			if(rs.next())
			{
			   rs.previous();//Moving To The Previous Row
			   while(rs.next())
			   {
				   ucode = rs.getInt(1);
				  
				   passName = rs.getString(3);
				  // passsDetails = rs.getString(4);
				   
				 
					
					
				   passsDetails=a.decrypt(rs.getString(4));
				   
				   String uid=rs.getString(5);
				   output=ucode+"`"+passName+"`"+passsDetails+"`"+uid;
				   sb.append(output+"~");
			   }
				   
			   sb.deleteCharAt(sb.lastIndexOf("~"));
				  
			}
			else
		    {
				 sb.append(info);
		    }
			  
		   
		}
		catch(Exception e)
		{
			System.out.println("Opps's Exception is in Admin->ViewUserFeedback Servlet : ");
			e.printStackTrace();
			out.println("Opps's Exception is in Admin->ViewUserFeedback Servlet : ");
			e.printStackTrace();
		}
	}
}
