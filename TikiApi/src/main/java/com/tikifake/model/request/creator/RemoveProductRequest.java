package com.tikifake.model.request.creator;

public class RemoveProductRequest {
	
	private Long cartId;

	private Long productId;
	
	

	public RemoveProductRequest() {
	}

	public RemoveProductRequest(Long productId, Long cartId) {
		this.cartId = cartId;
		this.productId = productId;
	}

	public Long getCartId() {
		return cartId;
	}

	public Long getProductId() {
		return productId;
	}
}
