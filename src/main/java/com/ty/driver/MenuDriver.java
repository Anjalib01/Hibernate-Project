package com.ty.driver;

import java.util.Scanner;

import com.ty.dao.MenuDao;
import com.ty.dao.UserDao;
import com.ty.dto.Menu;
import com.ty.dto.User;

public class MenuDriver {
	static Scanner sc = new Scanner(System.in);
	static UserDao userDao = new UserDao();
	static MenuDao menuDao = new MenuDao();

	public void createMenu() {
		System.out.println("Enter Manager Id");
		int manager_id = sc.nextInt();
		User user = userDao.getUserByUserId(manager_id);

		if (user != null) {
			Menu menu = new Menu();
			menu.setUser(user);

			Menu menu2 = menuDao.createMenu(menu);
		}else {
			System.out.println("Menu Not Prsent");
		}
		MainApp.crudMenu() ;
	}

	public void getMenu() {
		
		Menu menu=menuDao.getMenu();
		if(menu != null) {
			System.out.println(menu);
		}else {
			System.out.println("Not Found");
		}
		MainApp.crudMenu() ;
	}

	
}
