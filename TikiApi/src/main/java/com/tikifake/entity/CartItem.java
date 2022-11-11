package com.tikifake.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.tikifake.entity.embeddedid.CartItemId;

@Entity
@Table(name = "cart_item")
public class CartItem {

	@EmbeddedId
	public CartItemId id = new CartItemId();

	@MapsId("productId")
	@JoinColumns({ @JoinColumn(name = "product_id", referencedColumnName = "product_id") })
	@ManyToOne
	private Product product;

	@MapsId("cartId")
	@JoinColumns({ @JoinColumn(name = "cart_id", referencedColumnName = "cart_id") })
	@ManyToOne
	private Cart cart;
	
	@Column(name = "quantity")
	private int quantity;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "total_weight")
	private double totalWeight;
	
	@Column(name = "checked")
	private boolean isCheck;
	
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
}
