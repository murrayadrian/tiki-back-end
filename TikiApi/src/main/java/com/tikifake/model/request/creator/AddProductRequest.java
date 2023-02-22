package com.tikifake.model.request.creator;

import java.util.List;

public class AddProductRequest {

	private String categoryName;
	
	private String productName;
	
	private String description;
	
	private String brand;
	
	private Long shopId;
	
	private List<ProductItemRequest> items;
	
	private List<VariationRequest> variations;

	public String getCategoryName() {
		return categoryName;
	}

	public String getProductName() {
		return productName;
	}

	public String getDescription() {
		return description;
	}

	public String getBrand() {
		return brand;
	}

	public Long getShopId() {
		return shopId;
	}

	public List<ProductItemRequest> getItems() {
		return items;
	}

	public List<VariationRequest> getVariations() {
		return variations;
	}
}
