package com.tikifake.model.request.creator;

public class OrderItemCreatorRequest {
	
	private Long orderId;
	
	private Long productId;
	
	private int quantity;

	public Long getOrderId() {
		return orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
}
