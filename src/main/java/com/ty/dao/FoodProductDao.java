package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.FoodProduct;

public class FoodProductDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public FoodProduct createProduct(FoodProduct foodProduct) {
		et.begin();
		em.persist(foodProduct);
		em.merge(foodProduct.getMenu());
		et.commit();
		return foodProduct;
	}

	public static FoodProduct getProductByProductId(int product_id) {
		FoodProduct foodProduct = em.find(FoodProduct.class, product_id);
		return foodProduct;
	}

	public FoodProduct updateProduct(FoodProduct foodProduct) {
		et.begin();
		em.merge(foodProduct);
		et.commit();
		return foodProduct;
	}

	public boolean removeProduct(int product_id) {
		FoodProduct foodProduct = em.find(FoodProduct.class, product_id);

		et.begin();
		em.remove(foodProduct);
		et.commit();
		return true;
	}

}
