package com.ty.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.dao.FoodOrderDao;
import com.ty.dao.FoodProductDao;
import com.ty.dao.ItemDao;
import com.ty.dao.UserDao;
import com.ty.dto.FoodOrder;
import com.ty.dto.FoodProduct;
import com.ty.dto.Item;
import com.ty.dto.User;

public class FoodOrderDriver {
	static Scanner sc = new Scanner(System.in);
	static FoodOrderDao foodOrderDao = new FoodOrderDao();
	static User user = new User();
	static UserDao userDao = new UserDao();
	static ItemDao itemDao = new ItemDao();
	static ItemDriver itemDriver = new ItemDriver();
	static FoodProductDao foodProductDao = new FoodProductDao();

	public void createOrder() {
		System.out.println("=====================================");

		System.out.println("Enter Status");
		String order_status = sc.next();
		System.out.println("Enter Customer Name");
		String customer_name = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter Customer Contact Number");
		long customer_contactNumber = sc.nextLong();

		System.out.println("Enter How Many Items You want To add");
		int item_count = sc.nextInt();

		List<Item> list = new ArrayList<Item>();

		double total_price = 0;
		for (int i = 0; i < item_count; i++) {
			System.out.println("Enter Product Id");
			int product_id = sc.nextInt();

			FoodProduct product = foodProductDao.getProductByProductId(product_id);

			String product_name = product.getName();
			String product_type = product.getType();
			double price = product.getPrice();

			System.out.println("Enter Quantity");
			int product_quantity = sc.nextInt();

			double product_price = price * product_quantity;

			total_price = total_price + product_price;

			Item item = new Item(product_id, product_name, product_type, product_quantity, product_price);

			list.add(item);
		}

		FoodOrder foodOrder = new FoodOrder(order_status, total_price, customer_name, customer_contactNumber);

		System.out.println("Enter Customer Id");
		int cus_id = sc.nextInt();

		User user = userDao.getUserByUserId(cus_id);
		foodOrder.setUser(user);

		

		FoodOrder foodOrder2 = foodOrderDao.createOrder(foodOrder,list,user);

		MainApp.crudFoodOrder();
	}

	public void updateOrder() {
		System.out.println("Enter Order Id");
		int order_id = sc.nextInt();

		FoodOrder foodOrder = foodOrderDao.getOrderById(order_id);

		if (foodOrder != null) {
			System.out.println("Enter Status");
			String status = sc.next();

			FoodOrder foodOrder2 = foodOrderDao.updateOrder(order_id, status);
		}else {
			System.out.println("//** Food Order Not Present **//");
		}

		MainApp.crudFoodOrder();
	}

	public void removeOrder() {
		System.out.println("Enter Order Id");
		int order_id = sc.nextInt();

		FoodOrder foodOrder = foodOrderDao.getOrderById(order_id);

		if (foodOrder != null) {
			boolean result = foodOrderDao.removeOrder(foodOrder);

		}else {
			System.out.println("//** Food Order Not Present **//");
		}
		MainApp.crudFoodOrder();
	}

	public void getOrder() {
		System.out.println("Enter Order Id");
		int order_id = sc.nextInt();

		FoodOrder foodOrder = foodOrderDao.getOrderById(order_id);
		if (foodOrder != null) {
			System.out.println(foodOrder);
		} else {
			System.out.println("//** FOOD ORDER NOT FOUND **//");

		}
		MainApp.crudFoodOrder();
	}

	public void seeStatus() {
		System.out.println("Enter Order Id");
		int order_id = sc.nextInt();

		FoodOrder foodOrder = foodOrderDao.getOrderById(order_id);

		if (foodOrder != null) {
			String status = foodOrder.getStatus();
			System.out.println(status);
		}else {
			System.out.println("//** Food Order Not Present **//");
		}

		MainApp.customerActivity();
	}

}
