package com.tikifake.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.tikifake.entity.embeddedid.CartItemId;

@Entity
public class CartItem {

	@EmbeddedId
	public CartItemId id = new CartItemId();

	@MapsId("productItemId")
	@ManyToOne
	private ProductItem productItem;

	@MapsId("cartId")
	@ManyToOne
	private Cart cart;
	
	@Column(name = "quantity")
	private int quantity;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "checked")
	private boolean isCheck;

	//
	public String getProductName() {
		return productItem.getProduct().getName();
	};
	
	public String getProductImage() {
		return productItem.getProduct().getImage();
	}
	
	public double getProductPrice() {
		return productItem.getPrice();
	}
	//
	
	public Long getCartId() {
		return id.cartId;
	}
	public Long getProductItemId() {
		return id.productItemId;
	}
	
	public CartItemId getId() {
		return id;
	}

	public void setId(CartItemId id) {
		this.id = id;
	}

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
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

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
	
}
