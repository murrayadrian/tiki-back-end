package com.tikifake.model.request.creator;

import com.tikifake.entity.Category;

public class CategoryRequest {
	
	private String name;
	
	private String urlKey;
	
	private String parentKey;
	
	private int level;
	
	private boolean leaf;

	public Category convertDTOToEntity(Category parentCategory) {
		Category category = new Category();
		category.setName(name);
		category.setLeaf(leaf);
		category.setLevel(level);
		category.setUrlKey(urlKey);
		category.setParentCategory(parentCategory);
		return category;
	}

	public String getName() {
		return name;
	}
	

	public boolean isLeaf() {
		return leaf;
	}

	public int getLevel() {
		return level;
	}

	public String getParentKey() {
		return parentKey;
	}

	public String getUrlKey() {
		return urlKey;
	}
	

}
