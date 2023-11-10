package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Menu;

public class MenuDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public Menu createMenu(Menu menu) {
		et.begin();
		em.persist(menu);
		et.commit();
		return menu;
	}

	public Menu getMenu() {
		Query query = em.createQuery("select m from Menu m");
		List<Menu> menu = query.getResultList();

		if (!menu.isEmpty()) {
			Menu menu2 = menu.get(0);
			
			return menu2;
		}
		return null;
	}

}
