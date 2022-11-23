package com.tikifake.model.response.creator;

import com.tikifake.entity.CartItem;

public class CartItemCreatorResponse {

	private Long cartId;
	private Long productId;
	private String productName;
	private double productPrice;
	private int orderQuantity;
	private double totalPrice;
	private boolean isCheck;

	public CartItemCreatorResponse(CartItem cartItem) {
		this.cartId = cartItem.getCart().getId();
		this.productId = cartItem.getProduct().getId();
		this.productName = cartItem.getProduct().getName();
		this.productPrice = cartItem.getProduct().getPrice();
		this.orderQuantity = cartItem.getQuantity();
		this.totalPrice = cartItem.getTotalPrice();
		this.isCheck = cartItem.isCheck();
	}
	
	public Long getCartId() {
		return cartId;
	}

	public Long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public boolean isCheck() {
		return isCheck;
	}

}
