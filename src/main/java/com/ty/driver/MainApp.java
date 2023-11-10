package com.ty.driver;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dao.BranchDao;
import com.ty.dao.FoodOrderDao;
import com.ty.dao.FoodProductDao;
import com.ty.dao.ItemDao;
import com.ty.dao.MenuDao;
import com.ty.dao.UserDao;
import com.ty.dto.Branch;
import com.ty.dto.User;

public class MainApp {
	static UserDriver userDriver = new UserDriver();
	static UserDao userDao = new UserDao();

	static BranchDriver branchDriver = new BranchDriver();
	static BranchDao branchDao = new BranchDao();

	static FoodProductDriver foodProductDriver = new FoodProductDriver();
	static FoodProductDao foodProductDao = new FoodProductDao();

	static MenuDriver menuDriver = new MenuDriver();
	static MenuDao menuDao = new MenuDao();

	static FoodOrderDriver foodOrderDriver = new FoodOrderDriver();
	static FoodOrderDao foodOrderDao = new FoodOrderDao();

	static ItemDriver itemDriver = new ItemDriver();
	static ItemDao itemDao = new ItemDao();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//		String role = "manager";
//		userDriver.createUser(role);

		welcome();

	}

	private static void welcome() {
		System.out.println("-----CHOOSE THE ROLE-----");
		System.out.println("1: Manager 2: Staf 3: Customer 4: Back");
		int role_choice = sc.nextInt();

		switch (role_choice) {
		case 1:
			login("manager");
			break;
		case 2:
			login("staf");
			break;
		case 3:
			login("customer");
			break;
		case 4:
			break;

		}

	}

	private static void login(String login_role) {

		System.out.println("Enter Email To Login");
		String login_email = sc.next();
		System.out.println("Enter Password To Login");
		String login_password = sc.next();

		boolean resultOfLogin = userDao.verifyForLogin(login_email, login_password, login_role);

		if (resultOfLogin) {
			System.out.println("//** ----//LOGIN SUCCESSFULL//---- **//");
			if (login_role.equalsIgnoreCase("manager")) {
				managerActivity();
			} else if (login_role.equalsIgnoreCase("staf")) {
				stafActivity();
			} else if (login_role.equalsIgnoreCase("customer")) {
				customerActivity();
			}
		} else {
			
			System.out.println("=====================================");
			System.out.println("//** -----LOGIN FAILED----- **//");
			System.out.println("=====================================");
			login(login_role);
		}

	}

	public static void customerActivity() {
		System.out.println("-----CHOOSE CUSTOMER ACTIVITY-----");
		System.out.println("1: See Order Status 2: Back");
		int choice = sc.nextInt();

		if (choice == 1) {
			foodOrderDriver.seeStatus();
		} else if (choice == 2) {
			welcome();
		} else {
			System.out.println("Invalid Choice");
		}

	}

	public static void stafActivity() {
		System.out.println("-----CHOOSE STAF ACTIVITY-----");
		System.out.println("1: Customer 2: FoodOrder 3: Item 4: Back");

		int staf_activity_choice = sc.nextInt();

		switch (staf_activity_choice) {
		case 1:
			crudUser("customer");
			break;
		case 2:
			crudFoodOrder();
			break;
		case 3:
			crudItem();
			break;
		case 4:
			welcome();
			break;
		}

	}

	public static void crudItem() {
		System.out.println("-----CHOOSE Item ACTIVITY-----");
		System.out.println("1: Create 2: Update 3: Remove 4: Read 5: back");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			itemDriver.createItem();
			break;
		case 2:
			itemDriver.updateItem();
			break;
		case 3:
			itemDriver.deleteItem();
			break;
		case 4:
			itemDriver.getItem();
			break;
		case 5:
			managerActivity();
			break;
		}

	}

	public static void crudFoodOrder() {
		System.out.println("-----CHOOSE Food Order ACTIVITY-----");
		System.out.println("1: Create 2: Update 3: Remove 4: Read 5: back");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			foodOrderDriver.createOrder();
			break;
		case 2:
			foodOrderDriver.updateOrder();
			break;
		case 3:
			foodOrderDriver.removeOrder();
			break;
		case 4:
			foodOrderDriver.getOrder();
			break;
		case 5:
			managerActivity();
			break;

		}

	}

	public static void managerActivity() {
		System.out.println("-----CHOOSE MANAGER ACTIVITY-----");
		System.out.println("1: Branch 2: Menu 3: Product 4: Staf 5: Back");
		int manager_activity_choice = sc.nextInt();

		switch (manager_activity_choice) {
		case 1:
			crudBranch();
			break;
		case 2:
			crudMenu();
			break;
		case 3:
			crudProduct();
			break;
		case 4:
			crudUser("staf");
			break;

		case 5:
			welcome();
			break;
		}

	}

	public static void crudUser(String role) {
		System.out.println("-----CHOOSE User ACTIVITY-----");
		System.out.println("1: Create 2: Update 3: Remove 4: Read 5: back");

		int user_crud_choice = sc.nextInt();

		switch (user_crud_choice) {
		case 1:
			userDriver.createUser(role);
			break;
		case 2:
			userDriver.updateUser(role);
			break;
		case 3:
			userDriver.removeUser(role);
			break;
		case 4:
			userDriver.getUser(role);
			break;
		case 5:
			if (role.equalsIgnoreCase("manager")) {
				managerActivity();
				break;
			} else if (role.equalsIgnoreCase("staf")) {
				stafActivity();
				break;
			} else {
				customerActivity();
				break;
			}

		}

	}

	public static void crudProduct() {
		System.out.println("-----CHOOSE PRODUCT ACTIVITY-----");
		System.out.println("1: Create 2: Update 3: Remove 4: Read 5: back");

		int product_crud_choice = sc.nextInt();

		switch (product_crud_choice) {
		case 1:
			foodProductDriver.createProduct();
			break;
		case 2:
			foodProductDriver.updateProduct();
			break;
		case 3:
			foodProductDriver.removeProduct();
			break;
		case 4:
			foodProductDriver.getProduct();
			break;
		case 5:
			managerActivity();
			break;

		}

	}

	public static void crudMenu() {
		System.out.println("-----CHOOSE MENU ACTIVITY-----");
		System.out.println("1: Create 2: Read 3: back");

		int menu_crud_choice = sc.nextInt();

		switch (menu_crud_choice) {
		case 1:
			menuDriver.createMenu();
			break;
		case 2:
			menuDriver.getMenu();
			break;
		case 3:
			managerActivity();
			break;
		}

	}

	public static void crudBranch() {
		System.out.println("-----CHOOSE BRANCH ACTIVITY-----");
		System.out.println("1: Create 2: Update 3: Read 4: back");
		int branch_crud_choice = sc.nextInt();

		switch (branch_crud_choice) {
		case 1:
			branchDriver.createBranch();
			break;
		case 2:
			branchDriver.updateBranch();
			break;
		case 3:
			branchDriver.getBranch();
			break;
		case 4:
			managerActivity();
			break;

		}

	}

}
