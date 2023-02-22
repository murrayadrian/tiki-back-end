package com.tikifake.model.request.creator;

public class CheckItemRequest {
	
	private Long cartId;

	private Long productItemId;
	
	private String shopName;
	

	public Long getCartId() {
		return cartId;
	}

	public Long getProductItemId() {
		return productItemId;
	}

	public String getShopName() {
		return shopName;
	}
	
}
