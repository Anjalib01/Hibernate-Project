package com.ty.driver;

import java.util.Scanner;

import com.ty.dao.UserDao;
import com.ty.dto.Branch;
import com.ty.dto.User;

public class UserDriver {
	static Scanner sc = new Scanner(System.in);
	static UserDao userDao = new UserDao();

	public void createUser(String role) {

		System.out.println("Enter User Name");
		String user_name = sc.nextLine();
		System.out.println("Enter User Email");
		String user_email = sc.next();
		System.out.println("Enter User Password");
		String user_password = sc.next();

		User user = new User();

		user.setName(user_name);
		user.setEmail(user_email);
		user.setPassword(user_password);
		user.setRole(role);

		User user2 = userDao.createUser(user);

		if (user2 != null) {
			System.out.println("//** ----//USER CREATED SUCCESSFULLY//---- **//");
			System.out.println(userDao);
		} else {
			System.out.println("//** ----USER NOT CREATED---- **//");
		}

		MainApp.crudUser(role);
	}

	public void updateUser(String role) {
		System.out.println("Enter User Id");
		int user_id = sc.nextInt();

		User user = userDao.getUserByUserId(user_id);
		

		if (user != null) {
			
			while (true) {
				System.out.println("//** CHOOSE THE FOLLOWING ATTRIBUTE TO UPDATE **//");
				System.out.println("1: Update Name 2: Update Email 3: Update Password 4: Update Role 5: Done");

				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Enter User Name");
					String update_name = sc.nextLine();
					user.setName(update_name);
					break;
				case 2:
					System.out.println("Enter User Email");
					String update_email = sc.next();
					user.setEmail(update_email);
					break;
				case 3:
					System.out.println("Enter User Password");
					String update_password = sc.next();
					user.setPassword(update_password);
					break;
				case 4:
					System.out.println("Enter User Role");
					String update_role = sc.next();
					user.setRole(update_role);
					break;
				case 5:
					MainApp.crudUser(role);
					break;
				}

				User user2 = userDao.updateUser(user);
				System.out.println("//** Update Successfull **//");

			}
		} else {
			System.out.println("//** ----USER NOT FOUND---- **//");
		}
		MainApp.crudUser(role);

	}

	public void removeUser(String role) {
		System.out.println("Enter User Id");
		int user_id = sc.nextInt();

		User user = userDao.getUserByUserId(user_id);

		if (user != null) {
			boolean result = userDao.removeUser(user);
		}else {
			System.out.println("//** User Not Present **//");
		}
		MainApp.crudUser(role);

	}

	public void getUser(String role) {
		System.out.println("Enter User Id");
		int user_id = sc.nextInt();

		User user = userDao.getUserByUserId(user_id);

		if (user != null) {
			System.out.println("//** ----//USER FOUND SUCCESSFULLY//---- **//");

			System.out.println(user);
		} else {
			System.out.println("//** ----USER NOT FOUND---- **//");

		}
		MainApp.crudUser(role);

	}

}
