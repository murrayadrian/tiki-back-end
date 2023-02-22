package com.tikifake.model.response.creator;

import com.tikifake.entity.ProductItem;

public class ProductItemResponse {
	
	private Long id;
	
	private int qty;
	
	private double price;
	
	private int discountRate;
	
	private String image;

	
	public ProductItemResponse(ProductItem item) {
		this.id = item.getId();
		this.qty = item.getQty();
		this.price = item.getPrice();
		this.discountRate = item.getDiscountRate();
		this.image = item.getImage();
	}
	public Long getId() {
		return id;
	}

	public int getQty() {
		return qty;
	}

	public double getPrice() {
		return price;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public String getImage() {
		return image;
	}
}
