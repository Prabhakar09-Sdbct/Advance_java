package com.pm.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsertDynamic {

	public static void main(String[] args) throws Exception {

		// testInsert1();
		// testInsert2();
		// testInsert3(4, 14, "tony", 44, 24, 88);
		MarksheetBean bean = new MarksheetBean();
		bean.setId(5);
		bean.setRoll_no(15);
		bean.setName("peter");
		bean.setPhysics(72);
		bean.setChemistry(81);
		bean.setMaths(69);

		testInsert4(bean);

	}

	public static void testInsert1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(2, 12, 'will', 47, 83, 29)");

		int i = pstmt.executeUpdate();

		System.out.println("data inserted = " + i);
	}

	public static void testInsert2() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, 3);
		pstmt.setInt(2, 13);
		pstmt.setString(3, "shyam");
		pstmt.setInt(4, 55);
		pstmt.setInt(5, 65);
		pstmt.setInt(6, 75);

		int i = pstmt.executeUpdate();

		System.out.println("data inserted = " + i);

	}

	public static void testInsert3(int id, int roll_no, String name, int physics, int chemistry, int maths)
			throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, id);
		pstmt.setInt(2, roll_no);
		pstmt.setString(3, name);
		pstmt.setInt(4, physics);
		pstmt.setInt(5, chemistry);
		pstmt.setInt(6, maths);

		int i = pstmt.executeUpdate();

		System.out.println("data inserted = " + i);

	}

	public static void testInsert4(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setInt(2, bean.getRoll_no());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println("data inserted = " + i);
	}

}
