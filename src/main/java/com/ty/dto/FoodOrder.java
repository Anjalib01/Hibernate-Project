package com.ty.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String status;
	private double totalPrice;
	@CreationTimestamp
	private LocalDate orderCreatedTime;
	@UpdateTimestamp
	private LocalDate orderDeliverytime;
	private String customerName;
	private long contactNumber;
	
	@ManyToOne
	@JoinColumn
	private User user;
	
	@OneToMany
	private List<Item> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getOrderCreatedTime() {
		return orderCreatedTime;
	}

	public void setOrderCreatedTime(LocalDate orderCreatedTime) {
		this.orderCreatedTime = orderCreatedTime;
	}

	public LocalDate getOrderDeliverytime() {
		return orderDeliverytime;
	}

	public void setOrderDeliverytime(LocalDate orderDeliverytime) {
		this.orderDeliverytime = orderDeliverytime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public FoodOrder() {
		super();
	}

	public FoodOrder(String status, double totalPrice, String customerName, long contactNumber) {
		super();
		this.status = status;
		this.totalPrice = totalPrice;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
	}

	
	
	

}
