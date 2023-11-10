package com.ty.driver;

import java.util.Scanner;

import com.ty.dao.FoodProductDao;
import com.ty.dao.ItemDao;
import com.ty.dto.FoodProduct;
import com.ty.dto.Item;

public class ItemDriver {
	static Scanner sc = new Scanner(System.in);
	static ItemDao itemDao = new ItemDao();
	static FoodProductDao foodProductDao = new FoodProductDao();

	public void createItem() {
		System.out.println("Enter Product Id");
		int product_id = sc.nextInt();

		FoodProduct product = foodProductDao.getProductByProductId(product_id);

		String product_name = product.getName();
		String product_type = product.getType();
		double product_price = product.getPrice();

		System.out.println("Enter Quantity");
		int product_quantity = sc.nextInt();

		Item item = new Item(product_id, product_name, product_type, product_quantity, product_price);

		Item item2 = itemDao.createItem(item);

		MainApp.crudItem();

	}

	public void updateItem() {
		System.out.println("Enter Item Id");
		int item_id = sc.nextInt();

		Item item = itemDao.getItem(item_id);

		if (item != null) {
			System.out.println("Enter Quantity");
			int quantity = sc.nextInt();

			Item item2 = itemDao.updateItem(item, quantity);

		} else {
			System.out.println("Item Not Present");
		}
		MainApp.crudItem();
	}

	public void deleteItem() {
		System.out.println("Enter Item Id");
		int item_id = sc.nextInt();

		Item item = itemDao.getItem(item_id);

		if (item != null) {
			boolean result = itemDao.deleteItem(item);

		} else {
			System.out.println("Item Not Present");
		}
		MainApp.crudItem();
	}

	public void getItem() {
		System.out.println("Enter Item Id");
		int item_id = sc.nextInt();

		Item item = itemDao.getItem(item_id);
		if (item != null) {

			System.out.println(item);
		} else {
			System.out.println("Item Not Present");
		}

		MainApp.crudItem();
	}

}
