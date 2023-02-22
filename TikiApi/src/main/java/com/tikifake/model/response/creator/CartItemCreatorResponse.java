package com.tikifake.model.response.creator;

import com.tikifake.entity.CartItem;

public class CartItemCreatorResponse {

	private Long cartId;
	private Long productItemId;
	private String productName;
	private double price;
	private int orderQuantity;
	private double totalPrice;
	private boolean isCheck;

	public CartItemCreatorResponse(CartItem cartItem) {
		this.cartId = cartItem.getCart().getId();
		this.productItemId = cartItem.getProductItemId();
		this.productName = cartItem.getProductItem().getProduct().getName();
		this.price = cartItem.getProductItem().getPrice();
		this.orderQuantity = cartItem.getQuantity();
		this.totalPrice = cartItem.getTotalPrice();
		this.isCheck = cartItem.isCheck();
	}
	
	public Long getCartId() {
		return cartId;
	}

	public Long getProductItemId() {
		return productItemId;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
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
