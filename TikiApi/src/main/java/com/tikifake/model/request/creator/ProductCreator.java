package com.tikifake.model.request.creator;

import com.tikifake.entity.Category;
import com.tikifake.entity.Product;
import com.tikifake.entity.Shop;

public class ProductCreator {

	private String name;

	private String description;

	private String image;

	private String brand;
	
	private Long categoryId;
	
	private Long shopId;

	public Product convertDTOToEntity(Category category, Shop shop, String createdDate) {
		Product product = new Product();
		product.setName(this.name);
		product.setDescription(this.description);
		product.setImage(this.image);
		product.setBrand(this.brand);
		product.setCategory(category);
		product.setShop(shop);
		product.setCreatedDate(createdDate);
		
		return product;
	}
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public String getBrand() {
		return brand;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	
	public Long getShopId() {
		return shopId;
	}
}
