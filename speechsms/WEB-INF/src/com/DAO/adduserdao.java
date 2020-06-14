package com.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.servicelocator.serverconnector;
import com.util.AES_CBC_encryption_Decryption;

/**
 * Servlet implementation class adduserdao
 */
public class adduserdao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adduserdao() {
		super();
		
	}

	public static int checkid(String id) throws Exception {
		int check = 0;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql="select u_login_id from m_user where u_login_id='"+ id + "'";
			System.out.println("sql :"+sql);
			rs = stmt
					.executeQuery(sql);

			while (rs.next()) {
				check = 1;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return check;
	}

	public static int getuid(String id) throws Exception {
		int check = 0;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql="select u_code from m_user where u_login_id='"+ id + "'";
			System.out.println("sql :"+sql);
			rs = stmt
					.executeQuery(sql);

			while (rs.next()) {
				check = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return check;
	}
	public static String checkUser(String name, String pwd,String imei) throws Exception {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sb=new StringBuffer();

		String pno=null;
		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statment Established !");

			rs = stmt.executeQuery("select *from m_user where u_login_id='"+ name + "' and u_login_pwd='" + pwd + "'and imeino='" + imei + "'");

			AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();
			while (rs.next()) {
				pno = rs.getString(7);
				sb.append(rs.getString(7)+"~"+AES_CBC_encryption_Decryption.decrypt(rs.getString(6))+"~");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return sb.toString();
	}
public static String checkUser2(String name, String pwd) throws Exception {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sb=new StringBuffer();

		String pno=null;
		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			rs = stmt.executeQuery("select *from m_user where u_login_id='"+ name + "' and u_login_pwd='" + pwd + "'");

			AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();
			while (rs.next()) {
				pno = rs.getString(7);
				sb.append(rs.getString(7)+"~"+AES_CBC_encryption_Decryption.decrypt(rs.getString(6))+"~"+rs.getString(9)+"~");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return sb.toString();
	}

public static boolean updateUserOTP(String otp, String userid) throws Exception {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	boolean flag=false;

	try {
		serverconnector obj = new serverconnector();

		con = obj.connector();
		System.out.println("Connection Established !");

		stmt = con.createStatement();
		System.out.println("Statement Established !");

		int k = stmt.executeUpdate("update m_user set u_otp_pass='"+otp+"' where u_login_id='"+userid+"'");

		if(k>0)
		{
			flag=true;
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	} finally {
		con.close();
	}

	return flag;
}
	public static boolean checkMastpass(String name, String pwd,String mastpass) throws Exception {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql="select *from m_user where u_login_id='"+ name + "' and u_login_pwd='" + pwd + "' and master_key='"+mastpass+"'";
			System.out.println("sql :"+sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return flag;
	}
	
	
	
	public static boolean addPasswords(String uno, String dname,String uid,String upass) throws Exception {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		int k=0;
		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql="select * from m_password where user_code='"+uno+"' and pass_detail='"+dname+"' and u_id='"+uid+"'";
			System.out.println("sql :"+sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				k=rs.getInt(1);
			}
			if(k>0)
			{
				Connection con1 = null;
				Statement stmt1 = null;
				

				serverconnector obj1 = new serverconnector();
				con1 = obj1.connector();
				stmt1 = con1.createStatement();
				
				String sql1="update m_password set passwords='"+upass+"' where s_no='"+k+"'";
				int k2=stmt1.executeUpdate(sql1);
				if(k2>0)
				{
					flag=true;
				}
				
			}else
			{
				Connection con2 = null;
				Statement stmt2 = null;
				serverconnector obj2 = new serverconnector();
				con2 = obj2.connector();
				stmt2 = con2.createStatement();
				String sql2="insert into m_password (user_code,pass_detail,passwords,u_id)values('"+uno+"','"+dname+"','"+upass+"','"+uid+"')";
				int k3=stmt2.executeUpdate(sql2);
				if(k3>0)
				{
					flag=true;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return flag;
	}
	
	public static boolean deletePasswords(String dname, String pas,String uid) throws Exception {
		boolean flag = false;

		Connection con1 = null;
		

		int k=0;
		try {
			
				
				Statement stmt1 = null;
				

				serverconnector obj1 = new serverconnector();
				con1 = obj1.connector();
				stmt1 = con1.createStatement();
				
				String sql1="delete from m_password where pass_detail='"+dname+"' and passwords='"+pas+"' and u_id='"+uid+"'";
				int k2=stmt1.executeUpdate(sql1);
				if(k2>0)
				{
					flag=true;
				}
				
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con1.close();
		}

		return flag;
	}
	
	
	public static boolean checkCurrentpass(String id, String oldpwd) throws Exception {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			rs = stmt.executeQuery("select *from m_user where u_login_id='"+ id + "' and u_login_pwd='" + oldpwd + "'");

			while (rs.next()) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return flag;
	}
	
	public static String Verify_status(String name) throws Exception {
		boolean flag = false;

		String vry_status="";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			rs = stmt.executeQuery("select  verify_user_status from m_user where u_login_id='"+ name + "' ");

			while (rs.next()) {
				vry_status = rs.getString(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return vry_status;
	}


	public static String select_file(String remark,int ucode) throws Exception {
		boolean flag = false;

		String vry_status="";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			rs = stmt.executeQuery("select  f_name from m_trans where f_subject='"+ remark + "' and u_code='"+ucode+"' ");

			while (rs.next()) {
				vry_status = rs.getString(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return vry_status;
	}
	
	public static boolean checkUserId(String id) throws Exception {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			rs = stmt.executeQuery("select *from m_user where u_login_id='"+ id + "'");

			while (rs.next()) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return flag;
	}


	public static boolean checkOTP(String onetp) throws Exception {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			rs = stmt.executeQuery("select *from m_user where u_otp_pass='"+ onetp + "'");

			while (rs.next()) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return flag;
	}
	
	public static ArrayList selectkey(String userid) throws Exception
	{
		ArrayList list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			rs = stmt.executeQuery("select u_code,u_name,u_key from m_user where u_login_id='"+ userid + "'");

			while (rs.next())
			{
				list.add(rs.getInt(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return list;
	}
	
	public static String selectuserid(int code) throws Exception
	{
		String uid="";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			rs = stmt.executeQuery("select u_name from m_user where u_code='"+ code + "'");

			while (rs.next())
			{
				uid = rs.getString(1);
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return uid;
	}
	
	
	public static String select_subject(int usercode,String filename) throws Exception
	{
		String list = "";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			rs = stmt.executeQuery("select f_subject from m_trans where u_code='"+ usercode + "' and f_name = '"+filename+"'");

			while (rs.next())
			{
				list = rs.getString(1);
				
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return list;
	}
	
	public static ArrayList<String> getUploaded_file(String userid) throws Exception
	{
		ArrayList<String> list = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "select a.f_subject from m_trans a join m_user b on a.u_code=b.u_code where a.f_type='Uploaded' and b.u_login_id='"+userid+"'";
			
			rs = stmt.executeQuery(sql);

			
			while (rs.next())
			{
				list.add(rs.getString(1));
				
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return list;
	}
	
	public static ArrayList<String> getDownloaded_file(String userid) throws Exception
	{
		ArrayList<String> list = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "select a.f_name from m_trans a join m_user b on a.u_code=b.u_code where a.f_type='Downloaded' and b.u_login_id='"+userid+"'";
			
			rs = stmt.executeQuery(sql);

			
			while (rs.next())
			{
				list.add(rs.getString(1));
				
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return list;
	}
	
	
	public static boolean adduser(String id, String pwd, String name,String mastpass, String mobile,String otp,String status,String phone2,String imei) throws SQLException {
		System.out.println("New User Process...");
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			System.out.println("New User Process...");
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statment Established !");

			String sql = "insert into m_user(u_login_id,u_login_pwd,u_name,u_otp_pass,master_key,u_mobile,verify_user_status,alternate_no,imeino) values('"
					+ id
					+ "','"
					+ pwd
					+ "','"
					+ name
					+ "','"
					+ otp
					+ "','"
					+ mastpass + "','"+mobile+"','"+status+"','"+phone2+"','"+imei+"')";

			System.out.println("SQL Data :" + sql);
			stmt.executeUpdate(sql);

			flag = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return flag;
	}

	public static boolean addtrans(String date, String time, int ucode,String filename, String subject, String type) throws SQLException {
		
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			System.out.println("New User Process...");
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "insert into m_trans(t_date,t_time,u_code,f_name,f_subject,f_type) values('"
					+ date
					+ "','"
					+ time
					+ "','"
					+ ucode
					+ "','"
					+ filename
					+ "','"
					+ subject + "','" + type + "')";

			System.out.println("m_trans table :" + sql);
			stmt.executeUpdate(sql);

			flag = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

		return flag;
	}

	
	public static ArrayList<String> getUserinfo(String userid) {

		int flag = 0;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<String> list = new ArrayList<String>();

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "select  u_login_id,u_name,u_mobile from m_user where u_login_id='"
					+ userid + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;

	}

	public static ArrayList<String> getfile() {
		int flag = 0;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<String> list = new ArrayList<String>();

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "select img_name from m_image";
			rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				list.add(rs.getString(1));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;

	}

	public static int getUserCode(String user) {
		int flag = 0;

		// ArrayList<String> list = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		int code = 0;
		String amt = null;
		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "select u_code from m_user where u_login_id = '"
					+ user.trim() + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				code = rs.getInt(1);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return code;

	}

	public static ResultSet getUserPasswords(String ucode) {
		int flag = 0;

		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		int code = 0;
		String amt = null;
		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "select * from m_password where user_code = '"
					+ ucode.trim() + "'";
			System.out.println("sql2 :"+sql);
			rs = stmt.executeQuery(sql);
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rs;

	}
	public static String getUserSinglePassword(String ucode,String word) {
		int flag = 0;

				
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		StringBuffer sb=new StringBuffer();
		int code = 0;
		String amt = null;
		try {
			AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();
			
			
			
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "select * from m_password where user_code = '"
					+ ucode.trim() + "' and pass_detail='"+word+"'";
			System.out.println("sql2 :"+sql);
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				amt=a.decrypt(rs.getString(4));
				sb.append(amt+"~"+rs.getString(5)+"~");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sb.toString();

	}
	public static boolean changePass(String user, String newpass) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<String> list = new ArrayList<String>();

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "update m_user set u_login_pwd='" + newpass
					+ "' where u_login_id='" + user + "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			flag = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;

	}

	public static boolean changeMastPass(String user, String newpass) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<String> list = new ArrayList<String>();

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "update m_user set master_key='" + newpass
					+ "' where u_login_id='" + user + "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			flag = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;

	}
	public static boolean update_loginstatus(String otp) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<String> list = new ArrayList<String>();

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "update m_user set verify_user_status='Done' where u_otp_pass='" + otp + "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			flag = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;

	}
	public static boolean update_loginstatus2(String otp,String imei,String userid) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<String> list = new ArrayList<String>();

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "update m_user set verify_user_status='Done',imeino='"+imei+"' where u_login_id='" + userid + "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			flag = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;

	}
	public static ArrayList<String> getTotalAmt(int code, String date) {
		int flag = 0;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<String> list = new ArrayList<String>();

		try {
			serverconnector obj = new serverconnector();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt = con.createStatement();
			System.out.println("Statement Established !");

			String sql = "select t_amount from m_trans where u_code = '" + code
					+ "' and t_date = '" + date + "'";

			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;

	}

	
}
