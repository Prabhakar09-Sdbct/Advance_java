package com.pm.testJdbcDataSource;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundleApp {

	public static void main(String[] args) {
//		ResourceBundle rb = ResourceBundle.getBundle("com.pm.bundle.app");

//		ResourceBundle rb = ResourceBundle.getBundle("com.pm.bundle.app_hi");
		
//		ResourceBundle rb = ResourceBundle.getBundle("com.pm.bundle.app_sp");
		
//		ResourceBundle rb = ResourceBundle.getBundle("com.pm.bundle.app", new Locale("hi"));
		
		ResourceBundle rb = ResourceBundle.getBundle("com.pm.bundle.app", new Locale("sp"));
		
		System.out.println(rb.getString("greeting"));
		
//		System.out.println(rb.getString("hello"));
	}

}
