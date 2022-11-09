package com.tikifake.model.request.creator;

import com.tikifake.entity.Category;
import com.tikifake.entity.CategorySub;

public class CategorySubCreator {

	private String name;
	
	private Long categoryId;
	
	public CategorySub convertModelToEntity(Category category) {
		CategorySub categorySub = new CategorySub();
		categorySub.setName(this.name);
		categorySub.setCategory(category);
		return categorySub;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
}
