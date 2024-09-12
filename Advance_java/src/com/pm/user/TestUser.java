package com.pm.user;

import java.util.Scanner;

public class TestUser {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Please select an option:");
			System.out.println("1. Add");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Exit");
			System.out.print("Enter your choice (1-4): ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				testAdd(scanner);
				break;
			case 2:
				testUpdate(scanner);
				break;
			case 3:
				testDelete(scanner);
				break;
			case 4:
				System.out.println("Exiting the program.");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please select a valid option.");
			}
		}
	}

	public static void testAdd(Scanner scanner) throws Exception {
		UserBean bean = new UserBean();

		System.out.print("Enter the id: ");
		bean.setId(scanner.nextInt());
		scanner.nextLine();

		System.out.print("Enter the first Name: ");
		bean.setFirstName(scanner.nextLine());

		System.out.print("Enter the last Name: ");
		bean.setLastName(scanner.nextLine());

		System.out.print("Enter the login Id: ");
		bean.setLoginId(scanner.nextLine());

		System.out.print("Enter the password: ");
		bean.setPassword(scanner.nextLine());

		System.out.print("Enter the Address: ");
		bean.setAddress(scanner.nextLine());

		UserModal modal = new UserModal();
		modal.add(bean);
	}

	public static void testUpdate(Scanner scanner) throws Exception {
		UserBean bean = new UserBean();

		System.out.print("Enter the id: ");
		bean.setId(scanner.nextInt());
		scanner.nextLine();

		System.out.print("Enter the first Name: ");
		bean.setFirstName(scanner.nextLine());

		System.out.print("Enter the last Name: ");
		bean.setLastName(scanner.nextLine());

		System.out.print("Enter the login Id: ");
		bean.setLoginId(scanner.nextLine());

		System.out.print("Enter the password: ");
		bean.setPassword(scanner.nextLine());

		System.out.print("Enter the Address: ");
		bean.setAddress(scanner.nextLine());

		UserModal modal = new UserModal();
		modal.update(bean);
	}

	public static void testDelete(Scanner scanner) throws Exception {
		System.out.print("Enter the id: ");
		scanner.nextLine();
		
		UserModal modal = new UserModal();
		modal.delete(scanner.nextInt());
	}

}
