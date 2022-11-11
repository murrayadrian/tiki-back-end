package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.CategoryCreator;
import com.tikifake.model.request.update.CategoryUpdate;
import com.tikifake.model.response.detail.ICategoryDetail;
import com.tikifake.model.response.list.ICategoryList;

public interface CategoryService {

	public ICategoryDetail getDetailById(Long categoryId);

	public List<ICategoryList> getAll(int page);

	public CategoryCreator save(CategoryCreator categoryCreator);

	public CategoryCreator update(CategoryUpdate categoryUpdate);
}
