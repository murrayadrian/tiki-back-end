package com.tikifake.model.request.update;

import com.tikifake.entity.Category;

public class CategoryUpdate {
	
	private Long id;

	private String name;
	
	
	public Category convertUpdateToEntity() {
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		return category;
	}


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

}
