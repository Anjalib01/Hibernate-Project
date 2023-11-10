package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Branch;
import com.ty.dto.User;

public class BranchDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();


	public Branch getBranchByBranchId(int branch_id) {
		Branch branch = em.find(Branch.class, branch_id);

		return branch;
	}

	public List<Branch> getBranchByManagerEmail(String login_email) {
		User user = em.find(User.class, login_email);

		if (user != null) {
			List<Branch> listBranch = user.getBranch();
			return listBranch;

		} else {
			return null;
		}

	}

	public Branch updateBranch(Branch branch) {
		et.begin();
		em.persist(branch);
		et.commit();

		return branch;
	}

	public boolean removeBranch(int branch_id) {
		Branch branch = em.find(Branch.class, branch_id);
		if (branch != null) {
			et.begin();
			em.remove(branch);
			et.commit();
			return true;
		}
		return false;
	}

	public Branch createBranch(Branch branch, int manager_id) {
		User user = em.find(User.class, manager_id);
		if (user != null) {

			et.begin();
			branch.setUser(user);
			em.persist(branch);
			em.merge(user);
			et.commit();

			return branch;
		}

		return null;
		
	}

}
