package com.tikifake.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.tikifake.entity.embeddedid.OrderItemId;

@Entity
@Table(name="order_item")
public class OrderItem {
	
	@EmbeddedId
	public OrderItemId id = new OrderItemId();
	
	@MapsId("orderId")
	@JoinColumns({ @JoinColumn(name = "order_id", referencedColumnName = "order_id") })
	@ManyToOne
	private Order order;
	
	@MapsId("productId")
	@JoinColumns({ @JoinColumn(name = "product_id", referencedColumnName = "product_id") })
	@ManyToOne
	private Product product;
	
	
	@Column(name = "quantity")
	private int quantity;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "total_weight")
	private double totalWeight;
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
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

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}
	
}
