package com.tikifake.model.response.creator;

public class ChangeQuantityResponse {
	
	private int quantity;
	
	private double totalPrice;
	
	private double finalPrice;

	
	public ChangeQuantityResponse(int quantity, double totalPrice, double finalPrice) {
		this.finalPrice = finalPrice;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}


	public int getQuantity() {
		return quantity;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}	
	
	public double getFinalPrice() {
		return finalPrice;
	}
}
