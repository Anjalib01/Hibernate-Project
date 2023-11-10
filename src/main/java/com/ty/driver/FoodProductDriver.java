package com.ty.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.dao.FoodProductDao;
import com.ty.dao.MenuDao;
import com.ty.dto.FoodProduct;
import com.ty.dto.Menu;

public class FoodProductDriver {
	static Scanner sc = new Scanner(System.in);
	static FoodProductDao foodProductDao = new FoodProductDao();
	static MenuDao menuDao=new MenuDao();

	public void createProduct() {
		System.out.println("Enter Menu Id");
		int menu_id=sc.nextInt();
		
		Menu menu=menuDao.getMenu();
		

		System.out.println("Enter Food Product Name");
		String product_name = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter Food Product Type");
		String product_type = sc.nextLine();

		System.out.println("Enter Food Product About");
		String product_about = sc.nextLine();
		System.out.println("Enter Food Product Availability");
		String product_availability = sc.next();
		System.out.println("Enter Food Product price");
		double product_price = sc.nextDouble();

		FoodProduct foodProduct = new FoodProduct(product_name, product_type, product_about, product_availability,
				product_price);
		
		foodProduct.setMenu(menu);

		FoodProduct foodProduct2 = foodProductDao.createProduct(foodProduct);
		MainApp.crudProduct();
	}

	public void updateProduct() {
		System.out.println("Enter Product Id");
		int product_id = sc.nextInt();

		FoodProduct foodProduct = FoodProductDao.getProductByProductId(product_id);
		System.out.println(foodProduct);

		if (foodProduct != null) {

			System.out.println(" Update price ");

			System.out.println("Enter Product Price");
			double product_price = sc.nextDouble();
			foodProduct.setPrice(product_price);

			FoodProduct foodProduct2 = foodProductDao.updateProduct(foodProduct);

		}else {
			System.out.println("//** Product Not Found **//");
		}
		MainApp.crudProduct();
	}

	public void removeProduct() {
		System.out.println("Enter Product Id");
		int product_id = sc.nextInt();

		FoodProduct foodProduct = FoodProductDao.getProductByProductId(product_id);

		if (foodProduct != null) {
			boolean resultOfRemove = foodProductDao.removeProduct(product_id);

			if (resultOfRemove) {
				System.out.println("//** SUCCESSFULLY DELETED **//");
			}
		} else {
			System.out.println("//** PRODUCT NOT PRESENT **//");
		}
		MainApp.crudProduct();
	}

	public void getProduct() {
		System.out.println("Enter Product Id");
		int product_id = sc.nextInt();

		FoodProduct foodProduct = FoodProductDao.getProductByProductId(product_id);

		if (foodProduct != null) {
			System.out.println(foodProduct);
		} else {
			System.out.println("//** PRODUCT NOT PRESENT **//");
		}
		MainApp.crudProduct();
	}

}
