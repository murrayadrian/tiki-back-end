package com.tikifake.model.update;

import com.tikifake.entity.Category;
import com.tikifake.entity.CategorySub;

public class CategorySubUpdate {
	
	private Long id;
	
	private String name;
	
	private Long categoryId;
	
	
	public CategorySub convertToEntity(Category category) {
		CategorySub categorySub = new CategorySub();
		categorySub.setId(id);
		categorySub.setName(name);
		categorySub.setCategory(category);
		return categorySub;
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
