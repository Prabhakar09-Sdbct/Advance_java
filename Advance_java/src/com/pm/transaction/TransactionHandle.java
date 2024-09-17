package com.pm.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionHandle {
	
	public static void main(String[] args) throws Exception {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			
			con.setAutoCommit(false);
			Statement ssmt = con.createStatement();
			
			int i =ssmt.executeUpdate("insert into user values(10,'Prabhakar','Mandloi','prabhakar@gmail.com','pass1234','indore')");
			
			i =ssmt.executeUpdate("insert into user values(10,'Prabhakar','Mandloi','prabhakar@gmail.com','pass1234','indore')");
			
			i =ssmt.executeUpdate("insert into user values(11,'Prabhakar','Mandloi','prabhakar@gmail.com','pass1234','indore')");
			
            con.commit();
			System.out.println(" Data inserted "+ i);
		} catch (Exception e) {
			con.rollback();
			System.out.println("Exception "+ e.getMessage());
		} finally {
			con.close();
		}
		 
		
	}

}
