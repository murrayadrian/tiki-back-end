package com.tikifake.model.request.creator;

public class CheckItemRequest {
	
	private Long cartId;

	private Long productId;
	
	private boolean check;

	public Long getCartId() {
		return cartId;
	}

	public Long getProductId() {
		return productId;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
}
