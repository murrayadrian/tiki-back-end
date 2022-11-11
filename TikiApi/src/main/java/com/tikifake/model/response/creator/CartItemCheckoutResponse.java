package com.tikifake.model.response.creator;

import com.tikifake.entity.CartItem;

public class CartItemCheckoutResponse {

	private Long cartId;
	
	private Long productId;
	
	private String userName;
	
	private String userPhone;
	
	private String userAddress;
	
	private String productName;
	
	private double productPrice;
	
	private int orderQuantity;
	
	private double totalPrice;
	
	private boolean isCheck;

	public CartItemCheckoutResponse(CartItem cartItem) {
		this.cartId = cartItem.getCart().getId();
		this.productId = cartItem.getProduct().getId();
		this.userName = cartItem.getCart().getUser().getName();
		this.userPhone = cartItem.getCart().getUser().getPhone();
		this.userAddress = cartItem.getCart().getUser().getAddress();
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
	
	public String getUserName() {
		return userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public String getUserAddress() {
		return userAddress;
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
