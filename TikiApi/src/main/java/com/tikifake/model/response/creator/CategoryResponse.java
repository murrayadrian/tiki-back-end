package com.tikifake.model.response.creator;

import com.tikifake.entity.Category;

public class CategoryResponse {
	
	private Long id;
	
	private String name;
	
	private int level;
	
	private boolean leaf;
	
	public CategoryResponse convertEntityToResponse(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.level = category.getLevel();
		this.leaf = category.isLeaf();
		return this;
	}
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public int getLevel() {
		return level;
	}
	public boolean isLeaf() {
		return leaf;
	}

}
