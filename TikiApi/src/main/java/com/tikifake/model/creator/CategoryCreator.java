package com.tikifake.model.creator;

import com.tikifake.entity.Category;

public class CategoryCreator {
	
	private String name;

	private String description;

	public Category convertDTOToEntity() {
		Category category = new Category();
		category.setName(this.name);
		category.setDescription(this.description);
		return category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
