package com.ers.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	  public static Connection dbConnection() {
		  try {
			//1.Register driver for Application
			Class.forName("com.mysql.cj.jdbc.Driver");
				
			//2.Creating Connection with our database
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ers","root","root");
				
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	  }
	
}
