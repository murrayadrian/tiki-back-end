package com.tikifake.model.detail;

import java.time.LocalDate;

import com.tikifake.entity.Product;

public class ProductDetail {
	
	private Long id;
	
	private String name;

	private String description;

	private double price;

	private String image;

	private String brand;

	private String madeBy;
	
	private LocalDate createDate;

	private Long categorySubId;

	public ProductDetail(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.image = product.getImage();
		this.price = product.getPrice();
		this.brand = product.getBrand();
		this.createDate = product.getCreateDate();
		this.madeBy = product.getMadeBy();
//		this.categoryId = product.getCategory().getId();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Long getCategorySubId() {
		return categorySubId;
	}

	public void setCategorySubId(Long categorySubId) {
		this.categorySubId = categorySubId;
	}
	
}