package com.pm.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into marksheet values(4, 14, 'shyam', 44, 77, 90)");
		
		System.out.println("data inserted = " + i);
	}

}
