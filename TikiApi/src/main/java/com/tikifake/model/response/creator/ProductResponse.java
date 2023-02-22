package com.tikifake.model.response.creator;

import com.tikifake.entity.Product;

public class ProductResponse {

	private Long id;

	private String name;

	private double price;

	private String image;

	private int qtySold;
	
	private int discountRate;

	public ProductResponse(Product product, double cheeppestPrice, int qtySold, int discountRate, String image) {
		this.id = product.getId();
		this.name = product.getName();
		this.image = product.getImage();
		this.price = cheeppestPrice;
		this.qtySold = qtySold;
		this.discountRate = discountRate;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public int getQtySold() {
		return qtySold;
	}

	public int getDiscountRate() {
		return discountRate;
	}

}
