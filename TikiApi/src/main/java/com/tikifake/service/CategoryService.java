package com.tikifake.service;

import java.util.List;

import com.tikifake.model.ICategory;
import com.tikifake.model.creator.CategoryCreator;
import com.tikifake.model.response.CategoryResponse;
import com.tikifake.model.update.CategoryUpdate;

public interface CategoryService {

	public ICategory getDetailById(Long categoryId);

	public List<ICategory> getAll();

	public CategoryResponse save(CategoryCreator categoryCreator);

	public CategoryResponse update(CategoryUpdate categoryUpdate);
}
