package com.SpringBootFreshPrints.SpringBootFreshPrints.orders.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER")
public class Order {

	@Id
	@Column(name = "order_number")
	private int orderNumber;

	@Column(name = "order_Date")
	private Date orderDate;

	@Column(name = "order_description")
	private String orderDescription;

	@OneToMany(mappedBy = "order")
	private Set<OrderItem> orderItems;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderNumber, Date orderDate, String orderDescription) {
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.orderDescription = orderDescription;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
