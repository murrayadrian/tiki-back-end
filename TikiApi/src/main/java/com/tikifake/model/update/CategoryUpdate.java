package com.tikifake.model.update;

import com.tikifake.entity.Category;

public class CategoryUpdate {
	
	private Long id;

	private String name;

	private String description;
	
	
	public Category convertUpdateToEntity() {
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		return category;
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

}
