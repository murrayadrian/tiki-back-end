package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.CategoryCreator;
import com.tikifake.model.request.update.CategoryUpdate;
import com.tikifake.model.response.detail.ICategoryDetail;

public interface CategoryService {

	public ICategoryDetail getDetailById(Long categoryId);

	public List<ICategoryDetail> getAll();

	public CategoryCreator save(CategoryCreator categoryCreator);

	public CategoryCreator update(CategoryUpdate categoryUpdate);
}
