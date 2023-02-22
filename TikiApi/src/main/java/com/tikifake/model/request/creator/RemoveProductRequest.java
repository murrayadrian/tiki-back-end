package com.tikifake.model.request.creator;

public class RemoveProductRequest {
	
	private Long cartId;

	private Long productItemId;
	
	

	public RemoveProductRequest() {
	}

	public RemoveProductRequest(Long productItemId, Long cartId) {
		this.cartId = cartId;
		this.productItemId = productItemId;
	}

	public Long getCartId() {
		return cartId;
	}

	public Long getProductItemId() {
		return productItemId;
	}
}
