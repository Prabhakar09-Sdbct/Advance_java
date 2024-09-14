package com.pm.user;

import java.util.Iterator;
import java.util.List;

public class TestUser {

	public static void main(String[] args) throws Exception {
                testAdd();
//				testDelete();
//				testFindByPk();
//				testFindByLoginId();
//      		search();
	}

	public static void testAdd() throws Exception {
		UserBean bean = new UserBean();

		bean.setFirstName("prabhakar6");
		bean.setLastName("mandloi");
		bean.setLoginId("mandloi@gmail.com");
		bean.setPassword("1234");
		bean.setAddress("indore");

		UserModal modal = new UserModal();
		modal.add(bean);

		System.out.println("=============================");
	}

	public static void testUpdate() throws Exception {
		UserBean bean = new UserBean();

		bean.setId(2);
		bean.setFirstName("prabhakaran");
		bean.setLastName("mandloi");
		bean.setLoginId("mandloi@gmail.com");
		bean.setPassword("1234");
		bean.setAddress("indore");

		UserModal modal = new UserModal();
		modal.update(bean);

		System.out.println("=============================");
	}

	public static void testDelete() throws Exception {

		UserModal modal = new UserModal();
		modal.delete(2);

		System.out.println("=============================");
	}

	public static void testFindByPk() throws Exception {
		UserModal modal = new UserModal();
		UserBean bean = modal.findByPk(2);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getAddress());
		} else {
			System.out.println("user not found");
		}

		System.out.println("=============================");
	}
	
	public static void testFindByLoginId() throws Exception {
		UserModal modal = new UserModal();
		UserBean bean = modal.findByPk(2);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getAddress());
		} else {
			System.out.println("user not found");
		}

		System.out.println("=============================");
	}
	
	public static void search() throws Exception {
		UserBean bean = new UserBean();
		bean.setFirstName("prabhakar");
		bean.setLastName("mandloi");

		UserModal modal = new UserModal();
		List list = modal.search(bean, 1, 5);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();
			if (bean != null) {
				System.out.print(bean.getId());
				System.out.print("\t" + bean.getFirstName());
				System.out.print("\t" + bean.getLastName());
				System.out.print("\t" + bean.getLoginId());
				System.out.print("\t" + bean.getPassword());
				System.out.println("\t" + bean.getAddress());
			}
		}
		System.out.println("=============================");
	}
}
