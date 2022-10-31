package com.tikifake.model;

import com.tikifake.entity.Category;
import com.tikifake.entity.Product;

public class ProductCreator {

	private String name;

	private String description;

	private double price;

	private String image;

	private String brand;

	private String origin;

	private String model;

	private String madeBy;

	private Long categoryId;

	public Product convertDTOToEntity(Category category) {
		Product product = new Product();
		product.setName(this.name);
		product.setDescription(this.description);
		product.setPrice(this.price);
//		product.setCategory(category);
		product.setBrand(this.brand);
		product.setImage(this.image);
		product.setOrigin(this.origin);
		product.setModel(this.model);
		product.setMadeBy(this.madeBy);
		return product;
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

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}
