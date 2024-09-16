package com.pm.enrollment;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EnrollmentTest {

	public static void main(String[] args) throws Exception {
//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
	}

	private static void testSearch() throws Exception {
		EnrollmentBean bean = new EnrollmentBean();
		bean.setEnrollmentDate(new Date());
		bean.setGrade("A");
		bean.setStatus("Enrolled");
		
		EnrollmentModel model = new EnrollmentModel();
		List list = model.search(bean);
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			EnrollmentBean printBean = (EnrollmentBean) it.next();
			System.out.println(" Date is : " + printBean.getEnrollmentDate());
		}
	}

	private static void testDelete() throws Exception {
		EnrollmentModel model = new EnrollmentModel();
		model.delete(1);
	}

	private static void testUpdate() throws Exception {
		EnrollmentBean bean = new EnrollmentBean();
		bean.setId(1);
		bean.setStudentId(198);
		bean.setEnrollmentDate(new Date());
		bean.setGrade("B");
		bean.setStatus("Enrolled");
		
		EnrollmentModel model = new EnrollmentModel();
		model.update(bean);
	}

	private static void testAdd() throws Exception{
		EnrollmentBean bean = new EnrollmentBean();
		bean.setId(1);
		bean.setStudentId(198);
		bean.setEnrollmentDate(new Date());
		bean.setGrade("A");
		bean.setStatus("Enrolled");
		
		EnrollmentModel model = new EnrollmentModel();
		model.add(bean);
		
	}

	
}
