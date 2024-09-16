package com.pm.enrollment;

import java.util.Date;

public class EnrollmentTest {

	public static void main(String[] args) throws Exception {
		testAdd();
	}

	private static void testAdd() throws Exception{
		EnrollmentBean bean = new EnrollmentBean();
		bean.setId(1);
		bean.setStudentId(198);
		bean.setEnrollmentDate(new Date());
		bean.setGrade('A');
		bean.setStatus("Enrolled");
		
		EnrollmentModel model = new EnrollmentModel();
		model.add(bean);
		
	}

}
