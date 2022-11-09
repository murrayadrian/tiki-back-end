package com.tikifake.model.response.creator;

import com.tikifake.entity.CategorySub;

public class CategorySubResponse {
	
	private Long id;
	
	private String name;
	
	private Long categoryId;
	
	public CategorySubResponse convertEntityToResponse(CategorySub categorySub) {
		this.id = categorySub.getId();
		this.name = categorySub.getName();
		this.categoryId = categorySub.getCategory().getId();
		return this;
		
	}
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getCategoryId() {
		return categoryId;
	}
	
	
}
