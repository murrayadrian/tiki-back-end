package com.tikifake.model.request.update;

import java.time.LocalDateTime;

import com.tikifake.entity.CategorySub;
import com.tikifake.entity.Product;

public class ProductUpdate {
	
	private Long id;

	private String name;

	private String description;

	private double price;

	private String image;

	private String brand;

	private String madeIn;

	private Long categorySubId;
	
	
	
	public Product convertToEntity(CategorySub categorySub, LocalDateTime date) {
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setImage(image);
		product.setBrand(brand);
		product.setMadeIn(madeIn);
		product.setCreatedDate(date);
		product.setCategorySub(categorySub);
		return product;
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

	public Long getCategorySubId() {
		return categorySubId;
	}
}
