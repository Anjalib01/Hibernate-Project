package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.User;

public class UserDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public User createUser(User user) {

		User user2 = em.find(User.class, user.getId());

		if (user2 == null) {
			et.begin();
			em.persist(user);
			et.commit();
			
			return user;
		}
		return user2;
	}

	public boolean verifyForLogin(String login_email, String login_password, String login_role) {
		Query query = em.createQuery("select u from User u where u.email=?1 and u.password=?2 and u.role=?3");
		query.setParameter(1, login_email);
		query.setParameter(2, login_password);
		query.setParameter(3, login_role);
		List<User> userlist = query.getResultList();

		if (!userlist.isEmpty()) {
			User user = userlist.get(0);

			if (login_role.equalsIgnoreCase(user.getRole()) && login_password.equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public User getUserByUserId(int user_id) {
		User user = em.find(User.class, user_id);
		return user;
	}

	public User updateUser(User user) {
		et.begin();
		em.merge(user);
		et.commit();
		return null;
	}

	public boolean removeUser(User user) {

		et.begin();
		em.remove(user);
		et.commit();
		return true;
	}

}
