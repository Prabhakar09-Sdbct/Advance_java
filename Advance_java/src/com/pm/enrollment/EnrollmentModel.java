package com.pm.enrollment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentModel {

	public Integer nextPk() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt = con.prepareStatement("select max(id) from enrollment");

		ResultSet rs = psmt.executeQuery();
		int pk = 0;

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}

	public void add(EnrollmentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt = con.prepareStatement("insert into enrollment values (?, ?, ?, ?, ?)");

		psmt.setInt(1, nextPk());
		psmt.setInt(2, bean.getStudentId());
		psmt.setDate(3, new java.sql.Date(bean.getEnrollmentDate().getTime()));
		psmt.setString(4, bean.getGrade());
		psmt.setString(5, bean.getStatus());

		int i = psmt.executeUpdate();

		System.out.println(" Data Inserted " + i);
	}

	public void update(EnrollmentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt = con.prepareStatement(
				"update enrollment set student_id = ?, enrollment_date = ?, grade = ?, status = ? where id = ?");

		psmt.setInt(1, bean.getStudentId());
		psmt.setDate(2, new java.sql.Date(bean.getEnrollmentDate().getTime()));
		psmt.setString(3, bean.getGrade());
		psmt.setString(4, bean.getStatus());
		psmt.setInt(5, bean.getId());

		int i = psmt.executeUpdate();

		System.out.println(" Data updated " + i);
	}

	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt = con.prepareStatement("delete from enrollment where id = ?");

		psmt.setInt(1, id);
		int i = psmt.executeUpdate();

		System.out.println(" Data deleted " + i);
	}

	public List search(EnrollmentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		StringBuffer sql = new StringBuffer("select * from enrollment where 1 = 1");
		PreparedStatement psmt = con.prepareStatement(sql.toString());

		if (bean != null) {
			if (bean.getStudentId() > 0) {
				sql.append(" and student_id = "+bean.getStudentId());
			}
			if (bean.getEnrollmentDate() != null) {
				sql.append(" and enrollment_date = "+bean.getEnrollmentDate());
			}
			if (bean.getGrade() != null) {
				sql.append(" and grade = "+bean.getGrade());
			}
			if (bean.getStatus() != null) {
				sql.append(" and status = "+bean.getStatus());
			}
		}
		
		System.out.println("sql "+ sql);

		ResultSet rs = psmt.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new EnrollmentBean();
			bean.setId(rs.getInt(1));
			bean.setStudentId(rs.getInt(2));
			bean.setEnrollmentDate(rs.getDate(3));
			bean.setGrade(rs.getString(4));
			bean.setStatus(rs.getString(5));
			list.add(bean);
		}
		return list;
	}
}
