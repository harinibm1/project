package com.datavase.servicelocator;

import java.sql.Connection;
import java.sql.DriverManager;

public class serverconnector {
	public static Connection connector()
	{
		Connection con  = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver has loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_speechsms","root","admin");
            System.out.println("Connected"+con);
	       }
	    catch(Exception e)
		{
            System.out.println(e);
	    }
	    return con;
}
}
