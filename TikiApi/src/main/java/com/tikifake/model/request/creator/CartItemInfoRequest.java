package com.tikifake.model.request.creator;

public class CartItemInfoRequest {

	private Long cartId;

	private Long productItemId;
	
	private int quantity;

	public Long getCartId() {
		return cartId;
	}

	public Long getProductItemId() {
		return productItemId;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
}
