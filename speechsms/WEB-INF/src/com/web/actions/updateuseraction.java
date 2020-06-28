package com.web.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class updateuseraction
 */
public class updateuseraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateuseraction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		HttpSession hs=request.getSession();
        try {

			int n2=0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/traffic_db","root","admin");
			Statement st=con.createStatement();

			String id=request.getParameter("user_id");
			String user_name=request.getParameter("user_name");
			String user_doj=request.getParameter("user_doj");
			String user_div=request.getParameter("user_div");
			String user_city=request.getParameter("user_city");
			String user_desig=request.getParameter("user_desig");
			String user_cell=request.getParameter("user_cell");
			
			
			n2=st.executeUpdate("update m_user set u_name='"+user_name+"',u_doj='"+user_doj+"',u_division='"+user_div+"',u_city='"+user_city+"',u_designation='"+user_desig+"',u_mobile='"+user_cell+"' where u_login_id='"+id+"'");
			if(n2==1)
			{
				hs.setAttribute("update","success");
				rd=request.getRequestDispatcher("UserDetails.jsp");
				rd.forward(request,response);
			}
			else
			{
				hs.setAttribute("update","failed");
				rd=request.getRequestDispatcher("edituser.jsp");
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
