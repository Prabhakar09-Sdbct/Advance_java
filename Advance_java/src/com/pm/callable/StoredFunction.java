package com.pm.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class StoredFunction {
	
	public static void main(String[] args) throws Exception {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

            CallableStatement cls = con.prepareCall("{? = CALL square(?)}");
            cls.setInt(2, 10);

			cls.registerOutParameter(1, Types.INTEGER);

			cls.execute();

			System.out.println(" "+cls.getInt(1));
	}

}
