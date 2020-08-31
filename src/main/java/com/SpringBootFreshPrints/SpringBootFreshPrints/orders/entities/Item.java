package com.SpringBootFreshPrints.SpringBootFreshPrints.orders.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item {

	@Id
	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_description")
	private String itemDescription;
	
	@ManyToOne
	@JoinColumn(name = "order_item", nullable = false)
	private OrderItem orderitem;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String itemName, String itemDescription,OrderItem orderItem) {
		// TODO Auto-generated constructor stub
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

}
