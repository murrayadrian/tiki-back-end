package com.tikifake.model.response.list;

public interface ICartItemList {
	
	public Long getCartId();
	
	public double getTotalPrice();
	
	public Long getProductId();
	
	public String getProductName();
	
	public String getProductImage();
	
	public double getProductPrice();
	
	public int getQuantity();
	
	public boolean isCheck();
	
	public String getShopName();
	
}
