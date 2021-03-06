
package com.web.actions;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class deleteuseraction extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        HttpSession hs=request.getSession();
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/traffic_db","root","admin");
			Statement st=(Statement) con.createStatement();
			String id=request.getParameter("user_id");
			int n=st.executeUpdate("delete from m_user where u_login_id='"+id+"'");
			if(n==1)
			{
				hs.setAttribute("delete","success");
				rd=request.getRequestDispatcher("UserDetails.jsp");
				rd.forward(request,response);	
			}
			else
			{
				hs.setAttribute("delete","failed");
				rd=request.getRequestDispatcher("UserDetails.jsp");
				rd.forward(request,response);	
				
			}

        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
            out.close();
        }
    } 
    
}
