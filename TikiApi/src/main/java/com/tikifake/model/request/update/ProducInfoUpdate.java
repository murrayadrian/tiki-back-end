package com.tikifake.model.request.update;

import com.tikifake.entity.Category;
import com.tikifake.entity.Product;

public class ProducInfoUpdate {
	
	private Long id;

	private String name;

	private String description;

	private String image;

	private String brand;

	private Long categoryId;
	
	
	
	public Product convertToEntity(Category category) {
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		product.setImage(image);
		product.setBrand(brand);
		product.setCategory(category);
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

	public String getImage() {
		return image;
	}

	public String getBrand() {
		return brand;
	}


	public Long getCategoryId() {
		return categoryId;
	}
}
