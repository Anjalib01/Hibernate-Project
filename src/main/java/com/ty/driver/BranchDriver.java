package com.ty.driver;

import java.util.List;
import java.util.Scanner;

import com.ty.dao.BranchDao;
import com.ty.dto.Branch;

public class BranchDriver {
	static BranchDao branchDao = new BranchDao();
	static Scanner sc = new Scanner(System.in);

	public void createBranch() {
		System.out.println("Enter manager Id");
		int manager_id = sc.nextInt();

		System.out.println("Enter Branch Name");
		String branch_name = sc.next();
		System.out.println("Enter Branch Address");
		String branch_address = sc.nextLine();
		sc.nextLine();
		System.out.println("Enetr Branch PhoneNumber");
		long branch_phoneNumber = sc.nextLong();
		System.out.println("Enter Branch Email");
		String branch_email = sc.next();

		Branch branch = new Branch(branch_name, branch_address, branch_phoneNumber, branch_email);

		Branch branch1 = branchDao.createBranch(branch, manager_id);

		if (branch1 != null) {
			System.out.println("=====================================");

			System.out.println("//** ----//BRANCH CREATED SUCCESSFULLY//---- **//");
			System.out.println("Branch Name Is: " + branch1.getName());
			System.out.println("=====================================");

		} else {
			System.out.println("=====================================");

			System.out.println("//** ----BRANCH NOT CREATED---- **//");
			System.out.println("=====================================");

		}
		MainApp.crudBranch();

	}

	public void updateBranch() {

		System.out.println("Enter Branch Id");
		int branch_id = sc.nextInt();

		Branch branch2 = branchDao.getBranchByBranchId(branch_id);

		if (branch2 != null) {

			while (true) {
				System.out.println("=====================================");

				System.out.println("//** CHOOSE THE FOLLOWING ATTRIBUTE TO UPDATE **//");
				System.out.println("1: Update Name 2: Update Address 3: Update PhoneNumber 4: Update Email 5: Done");

				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Enter Branch Name");
					String update_name = sc.nextLine();
					branch2.setName(update_name);
					break;
				case 2:
					System.out.println("Enter Branch Address");
					String update_address = sc.nextLine();
					branch2.setAddress(update_address);
					break;
				case 3:
					System.out.println("Enter Branch PhoneNumer");
					long update_phoneNumber = sc.nextLong();
					branch2.setPhoneNumber(update_phoneNumber);
					break;
				case 4:
					System.out.println("Enter Branch Email");
					String update_email = sc.next();
					branch2.setEmail(update_email);
					break;
				case 5:
					MainApp.crudBranch();
					break;
				}

				Branch branch3 = branchDao.updateBranch(branch2);
				System.out.println("=====================================");

				System.out.println("//** UPDATED SUCCESSFULLY **//");
				System.out.println("=====================================");


			}
		} else {
			System.out.println("=====================================");

			System.out.println("//** BRANCH NOT FOUND **//");
			System.out.println("=====================================");

		}

		MainApp.crudBranch();
	}

	public void removeBranch() {
		System.out.println("Enter Branch Id");
		int branch_id = sc.nextInt();
		boolean resultOfRemove = branchDao.removeBranch(branch_id);

		if (resultOfRemove) {
			System.out.println("=====================================");

			System.out.println("//** ----//BRANCH DELETED SUCCESSFULLY//---- **//");
			System.out.println("=====================================");


		} else {
			System.out.println("=====================================");

			System.out.println("//** BRANCH NOT FOUND **//");
			System.out.println("=====================================");


		}
		MainApp.crudBranch();
	}

	public void getBranch() {
		System.out.println("Enter Branch Id");
		int branch_id = sc.nextInt();

		Branch branch2 = branchDao.getBranchByBranchId(branch_id);

		if (branch2 != null) {
			System.out.println("=====================================");

			System.out.println(branch2);
			System.out.println("=====================================");

		} else {
			System.out.println("=====================================");

			System.out.println("Branch Not Found");
			System.out.println("=====================================");

		}
		MainApp.crudBranch();

	}

}
