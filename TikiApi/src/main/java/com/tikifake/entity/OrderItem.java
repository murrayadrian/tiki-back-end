package com.tikifake.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.tikifake.entity.embeddedid.OrderItemId;

@Entity
public class OrderItem {
	
	@EmbeddedId
	public OrderItemId id = new OrderItemId();
	
	@MapsId("orderId")
	@ManyToOne
	private Order order;
	
	@MapsId("productItemId")
	@ManyToOne
	private ProductItem productItem;
	
	private int quantity;

	private double totalPrice;
	
	//
	public Long getOrderId() {
		return order.getId();
	}
	
	public Long getProductItemId() {
		return this.productItem.getId();
	}
	
	public double getProductItemPrice() {
		return this.productItem.getPrice();
	}
	//
	

	public int getQuantity() {
		return quantity;
	}

	public OrderItemId getId() {
		return id;
	}

	public void setId(OrderItemId id) {
		this.id = id;
	}

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
