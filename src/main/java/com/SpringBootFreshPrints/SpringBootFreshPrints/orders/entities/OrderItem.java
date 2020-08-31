package com.SpringBootFreshPrints.SpringBootFreshPrints.orders.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

	@Id
	@Column(name = "order_num")
	private int orderNumber;

	@Column(name = "order_item")
	private String orderItem;

	@Column(name = "order_description")
	private String orderDescription;

	@Column(name = "order_no")
	private long orderNo;

	@OneToMany(mappedBy = "orderitem")
	private Set<Item> items;

	@ManyToOne
	@JoinColumn(name = "order_number", nullable = false)
	private Order order;

	public OrderItem() {

	}

	public OrderItem(int orderNumber, String orderDescription, long orderNo, Set<Item> items, Order order) {

		this.orderNumber = orderNumber;
		this.orderDescription = orderDescription;
		this.orderNo = orderNo;
		this.items = items;
		this.order = order;

	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		items = items;
	}
}
