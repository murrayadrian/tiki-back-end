package com.tikifake.model.creator;

import com.tikifake.entity.Category;
import com.tikifake.entity.CategorySub;

public class CategorySubCreator {

	private String name;
	
	private Long categoryId;
	
	public CategorySub convertModelToEntity(Category category) {
		CategorySub categoryBrand = new CategorySub();
		categoryBrand.setName(this.name);
		categoryBrand.setCategory(category);
		return categoryBrand;
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
