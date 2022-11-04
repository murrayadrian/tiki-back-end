package com.tikifake.model;

import java.time.LocalDate;

import com.tikifake.entity.CategorySub;
import com.tikifake.entity.Product;

public class ProductCreator {

	private String name;

	private String description;

	private double price;

	private String image;

	private String brand;

	private String madeBy;
	
	private LocalDate createDate;

	private Long categorySubId;

	public Product convertDTOToEntity(CategorySub categorySub) {
		Product product = new Product();
		product.setName(this.name);
		product.setDescription(this.description);
		product.setPrice(this.price);
		product.setCategorySub(categorySub);
		product.setBrand(this.brand);
		product.setImage(this.image);
		product.setCreateDate(this.createDate);
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

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public Long getCategorySubId() {
		return categorySubId;
	}

	public void setCategorySubId(Long categorySubId) {
		this.categorySubId = categorySubId;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

}
