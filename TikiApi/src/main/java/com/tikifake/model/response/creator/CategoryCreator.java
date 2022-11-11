package com.tikifake.model.response.creator;

import com.tikifake.entity.Category;

public class CategoryCreator {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	
	public CategoryCreator convertEntityToResponse(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.description = category.getDescription();
		return this;
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
