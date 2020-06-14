package com.dhs.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.servicelocator.serverconnector;

/**
 * Servlet implementation class admindao
 */
public class admindao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public admindao() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static int logindao(String adminid, String adminpass) throws SQLException
	{
		int flag=0;
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;

		try
		{
			serverconnector obj=new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");

			String sql="select admin_id,admin_password from m_admin where admin_id='"+adminid+"' and admin_password='"+adminpass+"'";
			
			rs=(ResultSet) stmt.executeQuery(sql);

			while(rs.next())
			{
	
				flag=1;
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return flag;
	}
    
    
    public static boolean loginCHK(String name, String pass) 
	{
    	Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		boolean flag=false;
		try
		{
			serverconnector obj=new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");

			rs = stmt.executeQuery("select * from m_admin where admin_id='"+name+"' and admin_password='"+pass+"'");
			while(rs.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO.loginCHK()....."+e);
		}
		return flag;
	}
    
    public static boolean changepwd(String adminid, String newpwd) throws SQLException
	{
		int flag=0,n2;
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		boolean flg = false;

		try
		{
			serverconnector obj=new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");
			
			stmt.executeUpdate("update m_admin set admin_password='"+newpwd+"' where admin_id='"+adminid+"'");
			flg = true;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return flg;
	}
    
    
    public static int editUser(String adminid, String name, String city,String mobile,int code) throws SQLException
	{
		int flag=0,n2;
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;

		try
		{
			serverconnector obj=new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");
			
			n2=stmt.executeUpdate("update m_user set u_login_id='"+adminid+"',u_name='"+name+"',u_city='"+city+"',u_mobile='"+mobile+"' where u_code='"+code+"'");
			
			System.out.println(n2);
			if(n2==1)
			{
				flag=1;
				System.out.println("Flag :"+flag);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return flag;
	}
    
    public static int updatecloud(String name, String url, String uname,String pass,int code) throws SQLException
   	{
   		int flag=0,n2;
   		Connection con=null;
   		Statement stmt = null;
   		ResultSet rs=null;

   		try
   		{
   			serverconnector obj=new serverconnector();

   			con = obj.connector();
   			System.out.println("Connection Established !");

   			stmt=con.createStatement();
   			System.out.println("Statment Established !");
   			
   			n2=stmt.executeUpdate("update m_cloud set c_name='"+name+"',c_url='"+url+"',c_uname='"+uname+"',c_pwd='"+pass+"' where c_code='"+code+"'");
   			
   			System.out.println(n2);
   			if(n2==1)
   			{
   				flag=1;
   				System.out.println("Flag :"+flag);
   			}
   		}
   		catch(Exception e)
   		{
   			System.out.println(e.getMessage());
   		}
   		finally
   		{
   			con.close();
   		}

   		return flag;
   	}
    
    public static boolean deleteUser(String id) 
	{
		boolean flag=false;
		
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		try
		{
			serverconnector obj=new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");
			
			String sql = "delete from m_user where u_code='"+id+"'";
			System.out.println(sql);
			int i=stmt.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete user Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUser()....."+e);
		}
		return flag;
	}
    public static boolean deleteUserfrompassword(String id) 
	{
		boolean flag=false;
		
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		try
		{
			serverconnector obj=new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");
			
			String sql = "delete from m_password where user_code='"+id+"'";
			System.out.println(sql);
			int i=stmt.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete user Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUser()....."+e);
		}
		return flag;
	}
	
    
    public static String username(String adminid) throws SQLException
	{
		int flag=0;
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		String name="";
		try
		{
			serverconnector obj=new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");

			String sql="select admin_name from m_admin where admin_id='"+adminid+"'";
			
			rs=(ResultSet) stmt.executeQuery(sql);

			while(rs.next())
			{
				name=rs.getString("admin_name");
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return name;
	}
    
    public static ResultSet getUser() throws SQLException
	{
		int flag=0;
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		String name="";
		try
		{
			serverconnector obj=new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");

			String sql="select *from m_user";
			
			rs=stmt.executeQuery(sql);

			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return rs;
	}
    
    public static ResultSet getServer() throws SQLException
	{
		
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		
		try
		{
			serverconnector obj=new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");

			String sql="select *from m_cloud";
			
			rs=stmt.executeQuery(sql);

			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return rs;
	}

    public static ResultSet getTrans() throws SQLException
	{
		
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		
		try
		{
			serverconnector obj=new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");

			String sql="select *from m_password";
			
			rs=stmt.executeQuery(sql);

			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return rs;
	}

    public static String getUserName(String uid) throws SQLException
   	{
   		
   		Connection con=null;
   		Statement stmt = null;
   		ResultSet rs=null;
   		String uname=null;
   		
   		try
   		{
   			serverconnector obj=new serverconnector();

   			con = obj.connector();
   			//System.out.println("Connection Established !");

   			stmt=con.createStatement();
   			System.out.println("Statment Established !");

   			String sql="select u_name from m_user where u_code='"+uid+"'";
   			
   			rs=stmt.executeQuery(sql);

   			while(rs.next())
   			{
   				uname=rs.getString(1);
   			}
   			
   		}
   		catch(Exception e)
   		{
   			System.out.println(e.getMessage());
   		}
   		
   		return uname;
   	}

	
}
