package com.pm.enrollment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EnrollmentModel {

	public Integer nextPk() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt = con.prepareStatement("select max(id) from enrollment");
  

		ResultSet rs = psmt.executeQuery();
		int pk = 0;
		
		while (rs != null) {
			pk = rs.getInt(1);
		}
		return pk+1;
	}
	
	public void add(EnrollmentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt = con.prepareStatement("insert into enrollment values (?, ?, ?, ?, ?)");

		psmt.setInt(1, nextPk());
		psmt.setInt(2, bean.getStudentId());
		psmt.setDate(3, new java.sql.Date(bean.getEnrollmentDate().getTime()));
		psmt.setString(4, String.valueOf(bean.getGrade()));
		psmt.setString(5, bean.getStatus());

		int i = psmt.executeUpdate();
		
		System.out.println(" Data Inserted " + i);
	}

//	id = ?, student_id = ?, enrollment_date = ?, grade = ?, status = ?

}
