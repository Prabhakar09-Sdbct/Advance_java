package com.pm.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class StoredProcedure {

	public static void main(String[] args) throws Exception {

//		testIn();
//		testOut();
		testInOut();
	}

	private static void testIn() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		CallableStatement cls = con.prepareCall("{CALL userIn(?)}");

		cls.setInt(1, 1);

		cls.execute();

		ResultSet rs = cls.getResultSet();

		while (rs.next()) {
			System.out.println(" " + rs.getString(2));
		}
	}

	private static void testOut() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		CallableStatement cls = con.prepareCall("{CALL userOut(?)}");

		cls.registerOutParameter(1, Types.INTEGER);

		cls.execute();

		int s1 = cls.getInt(1);

		System.out.println(" s1 =>" + s1);

	}

	private static void testInOut() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		CallableStatement cls = con.prepareCall("{CALL userInOut(?)}");

		cls.setInt(1, 1);
		
		cls.registerOutParameter(1, Types.INTEGER);

		cls.execute();

		int s1 = cls.getInt(1);

		System.out.println(" s1 =>" + s1);
	}

}
