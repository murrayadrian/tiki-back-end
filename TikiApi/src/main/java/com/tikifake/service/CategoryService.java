package com.tikifake.service;

import java.util.List;

import com.tikifake.entity.Category;
import com.tikifake.model.ICategory;
import com.tikifake.model.creator.CategoryCreator;

public interface CategoryService {

	public ICategory getDetailById(Long categoryId);

	public List<ICategory> getAll();

	public Category save(CategoryCreator categoryCreator);

	public Category update(Category category);
}
