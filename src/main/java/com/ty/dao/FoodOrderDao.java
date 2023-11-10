package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.FoodOrder;
import com.ty.dto.Item;
import com.ty.dto.User;

public class FoodOrderDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public FoodOrder createOrder(FoodOrder foodOrder, List<Item> list, User user) {
		foodOrder.setItems(list);
		et.begin();
		em.persist(foodOrder);
		for(int i=0;i<list.size();i++) {
			em.persist(list.get(i));
		}
		em.merge(foodOrder.getUser());
        et.commit();
		return foodOrder;

	}

	public FoodOrder getOrderById(int order_id) {
		FoodOrder foodOrder = em.find(FoodOrder.class, order_id);

		return foodOrder;
	}

	public FoodOrder updateOrder(int order_id, String status) {
		FoodOrder foodOrder = em.find(FoodOrder.class, order_id);
		foodOrder.setStatus(status);

		et.begin();
		em.merge(foodOrder);
		et.commit();
		return foodOrder;
	}

	public boolean removeOrder(FoodOrder foodOrder) {
		et.begin();
		em.remove(foodOrder);
		et.commit();
		return true;
	}

}
