package com.tikifake.model.response.list;

public interface IOrderItem {
	
	public Long getOrderId();
	
	public Long getProductId();
	
	public String getProductName();
	
	public int getQuantity();
	
	public double getProductPrice();
	
	public double getTotalPrice();
	
	public double getTotalWeight();
}
