package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.CategoryCreator;
import com.tikifake.model.request.update.CategoryUpdate;
import com.tikifake.model.response.creator.CategoryResponse;
import com.tikifake.model.response.detail.ICategoryDetail;

public interface CategoryService {

	public ICategoryDetail getDetailById(Long categoryId);

	public List<ICategoryDetail> getAll();

	public CategoryResponse save(CategoryCreator categoryCreator);

	public CategoryResponse update(CategoryUpdate categoryUpdate);
}
