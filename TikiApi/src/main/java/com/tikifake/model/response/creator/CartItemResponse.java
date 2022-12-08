package com.tikifake.model.response.creator;

import com.tikifake.entity.CartItem;

public class CartItemResponse {
	
	private Long cartId;
	
	private Long productId;
	
	private double totalPrice;
	
	private boolean check;
	
	public CartItemResponse(CartItem cartItem) {
		this.cartId = cartItem.getCartId();
		this.productId = cartItem.getProductId();
		this.totalPrice = cartItem.getTotalPrice();
		this.check = cartItem.isCheck();
	}

	public Long getCartId() {
		return cartId;
	}

	public Long getProductId() {
		return productId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public boolean isCheck() {
		return check;
	}
}
