package com.pm.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserModal {
	
	public void add(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
		
		psmt.setInt(1, bean.getId());
		psmt.setString(2, bean.getFirstName());
		psmt.setString(3, bean.getLastName());
		psmt.setString(4, bean.getLoginId());
		psmt.setString(5, bean.getPassword());
		psmt.setString(6, bean.getAddress());
		
	   int i = psmt.executeUpdate();
	   System.out.println(" Data inserted : "+i);
	}
	
	public void update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt =  con.prepareStatement("update user set first_name = ?, last_name = ?, login_id = ?, password = ?, address = ? where id = ?");
		
		psmt.setString(1, bean.getFirstName());
		psmt.setString(2, bean.getLastName());
		psmt.setString(3, bean.getLoginId());
		psmt.setString(4, bean.getPassword());
		psmt.setString(5, bean.getAddress());
		psmt.setInt(6, bean.getId());
		
	   int i = psmt.executeUpdate();
	   System.out.println(" Data updated : "+i);
	
	}
	
	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt =  con.prepareStatement("delete from user where id = ?");
	
		psmt.setInt(1, id);
		
	   int i = psmt.executeUpdate();
	   System.out.println(" Data deleted : "+i);
	
	}

}
