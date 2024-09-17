package com.pm.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskModel {

	public Integer nextPk() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt = con.prepareStatement("select max(id) from task");
		
		ResultSet rs = psmt.executeQuery();
		int pk = 0;
		while(rs.next()) {
		  pk =rs.getInt(1);
		}
		return pk + 1;
	}

	public void add(TaskBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt = con.prepareStatement("insert into task values (?, ?, ?, ?, ?, ?, ?)");
		
		psmt.setInt(1, bean.getId());
		psmt.setString(2, bean.getTaskName());
		psmt.setString(3, bean.getDescription());
		psmt.setString(4, bean.getAssignTo());
		psmt.setDate(5, new java.sql.Date(bean.getDueDate().getTime()));
		psmt.setString(6, bean.getPriority());
		psmt.setString(7, bean.getStatus());
		
		int i = psmt.executeUpdate();
		
		System.out.println("Data inserted "+i);
	}
	
	public void update(TaskBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt = con.prepareStatement("update task set task_name= ?, description=?, assigned_to=?, due_date=?, priority= ?, status=? where id = ?");
		
		psmt.setString(1, bean.getTaskName());
		psmt.setString(2, bean.getDescription());
		psmt.setString(3, bean.getAssignTo());
		psmt.setDate(4, new java.sql.Date(bean.getDueDate().getTime()));
		psmt.setString(5, bean.getPriority());
		psmt.setString(6, bean.getStatus());
		psmt.setInt(7, bean.getId());
		
		int i = psmt.executeUpdate();
		
		System.out.println("Data updated "+i);
	}
	
	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement psmt = con.prepareStatement("delete from task where id = ?");
		
		psmt.setInt(1, id);
		
		int i = psmt.executeUpdate();
		
		System.out.println("Data deleted "+i);
	}
	
	public List search(TaskBean bean, int pageNo, int pageSize) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		StringBuffer sql = new StringBuffer("select * from task where 1=1");
		PreparedStatement psmt = con.prepareStatement(sql.toString());
		
		if(bean != null) {
			if(bean.getTaskName() != null) {
				sql.append(" and task_name ="+bean.getTaskName());
			}
			if(bean.getDescription() != null) {
				sql.append(" and description ="+bean.getDescription());
			}
			if(bean.getDescription() != null) {
				sql.append(" and assigned_to ="+bean.getAssignTo());
			}
			if(bean.getDueDate() != null) {
				sql.append(" and due_date ="+bean.getDueDate());
			}
			if(bean.getPriority() != null) {
				sql.append(" and priority ="+bean.getPriority());
			}
			if(bean.getStatus() != null) {
				sql.append(" and status ="+bean.getStatus());
			}
		}
		
		if(pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit "+pageNo + "," + pageSize);
		}
		
		ResultSet rs = psmt.executeQuery();
		
		List list = new ArrayList();
		while(rs.next()) {
			bean = new TaskBean();
			bean.setId(rs.getInt(1));
			bean.setTaskName(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setAssignTo(rs.getString(4));
			bean.setDueDate(rs.getDate(5));
			bean.setPriority(rs.getString(6));
			bean.setStatus(rs.getString(7));
			list.add(bean);
		}
		return list;
	}
	
}
