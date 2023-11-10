package com.ty.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Item;

public class ItemDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public Item createItem(Item item) {
		et.begin();
		em.persist(item);
		et.commit();
		return item;
	}

	public Item getItem(int item_id) {
		Item item = em.find(Item.class, item_id);

		return item;
	}

	public Item updateItem(Item item, int quantity) {
		item.setQuantity(quantity);
		et.begin();
		em.merge(item);
		et.commit();
		return item;
	}

	public boolean deleteItem(Item item) {
		et.begin();
		em.remove(item);
		et.commit();
		
		return true;
	}

}
