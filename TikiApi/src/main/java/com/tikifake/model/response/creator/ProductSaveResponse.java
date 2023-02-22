package com.tikifake.model.response.creator;

import com.tikifake.entity.Product;

public class ProductSaveResponse {

	private Long id;
	
	private String name;
	
	private String createdDate;
	
	public ProductSaveResponse(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.createdDate = product.getCreatedDate();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCreatedDate() {
		return createdDate;
	}
}
