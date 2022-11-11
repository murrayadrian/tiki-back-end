package com.tikifake.model.request.creator;

import com.tikifake.entity.Category;
import com.tikifake.entity.CategorySub;
import com.tikifake.entity.Product;

public class ProductCreator {

	private String name;

	private String description;

	private double price;

	private String image;

	private String brand;

	private String madeIn;

	private Long categorySubId;

	public Product convertDTOToEntity(CategorySub categorySub) {
		Product product = new Product();
		product.setName(this.name);
		product.setDescription(this.description);
		product.setPrice(this.price);
		product.setImage(this.image);
		product.setBrand(this.brand);
		product.setMadeIn(this.madeIn);
		product.setCategorySub(categorySub);
		return product;
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
