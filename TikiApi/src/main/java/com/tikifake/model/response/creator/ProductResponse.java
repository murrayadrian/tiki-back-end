package com.tikifake.model.response.creator;

import java.time.LocalDateTime;

import com.tikifake.entity.Product;

public class ProductResponse {

	private Long id;

	private String name;

	private String description;

	private double price;

	private String image;

	private String brand;

	private String madeIn;
	
	private LocalDateTime createdDate;

	private Long categorySubId;

	public ProductResponse(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.image = product.getImage();
		this.price = product.getPrice();
		this.brand = product.getBrand();
		this.madeIn = product.getMadeIn();
		this.createdDate = product.getCreatedDate();
		this.categorySubId = product.getCategorySub().getId();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public String getBrand() {
		return brand;
	}

	public String getMadeIn() {
		return madeIn;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public Long getCategorySubId() {
		return categorySubId;
	}

}
