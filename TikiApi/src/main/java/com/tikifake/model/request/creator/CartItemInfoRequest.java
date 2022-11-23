package com.tikifake.model.request.creator;

public class CartItemInfoRequest {

	private Long cartId;

	private Long productId;
	
	private int quantity;

	public Long getCartId() {
		return cartId;
	}

	public Long getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
}
