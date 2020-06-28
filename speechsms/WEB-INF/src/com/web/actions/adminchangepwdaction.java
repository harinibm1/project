/**
 * 
 */
package com.web.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DAO.*;


/**
 * @author Amutha

 *Project:-Cloud_Mona
 
 *File:-ChangePass.java
 */
public class adminchangepwdaction extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			int no=Integer.parseInt(request.getParameter("no"));
			if(no==1)
			{
				String name=request.getParameter("name");
				request.setAttribute("admin",name);
				RequestDispatcher rd=request.getRequestDispatcher("AdminChangePwd.jsp?no=0");
				rd.forward(request, response);
			}
			if(no==2)
			{
				String id=request.getParameter("user_id");
				String pass=request.getParameter("pass");
				String npass=request.getParameter("npass");
				String cpass=request.getParameter("cpass");
				String admin=request.getParameter("admin");
				request.setAttribute("admin", admin);
				
				//DAO dao=DAO.getInstance();
				boolean result=admindao.loginCHK(admin, pass);
				if(result)
				{
					if(npass.equals(cpass))
					{
						result=admindao.changepwd(id, cpass);
						if(result)
						{
							
							RequestDispatcher rd=request.getRequestDispatcher("AdminChangePwd.jsp?no=4");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher("AdminChangePwd.jsp?no=3");
							rd.forward(request, response);
						}
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher("AdminChangePwd.jsp?no=2");
						rd.forward(request, response);
					}
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("AdminChangePwd.jsp?no=1");
					rd.forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin ChangePass Servlet......"+e);
			out.println("Opps's Error is in Admin ChangePass Servlet......"+e);
		}
	}
}
