package com.pm.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBCDataSource {

	public static void main(String[] args) throws Exception {

		Connection con = JDBCDataSource.getConnection();
		PreparedStatement psmt = con.prepareStatement("Select * from user where id = 1");

		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			System.out.print(" " + rs.getInt(1));
			System.out.print(" \t" + rs.getString(2));
			System.out.println(" \t" + rs.getString(3));

		}
		
		JDBCDataSource.closeConnection(con);
	}

}
