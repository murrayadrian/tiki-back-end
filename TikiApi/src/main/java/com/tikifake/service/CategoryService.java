package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.CategoryRequest;
import com.tikifake.model.request.update.CategoryUpdate;
import com.tikifake.model.request.update.LeafCategory;
import com.tikifake.model.response.creator.CategoryResponse;
import com.tikifake.model.response.detail.ICategoryDetail;
import com.tikifake.model.response.list.ICategoryList;

public interface CategoryService {

	public ICategoryDetail getDetailById(Long categoryId);

	public List<ICategoryList> getAll();
	
	public List<ICategoryList> getLevel1Category(int level);
	
	public List<ICategoryList> getSubCategory(Long parentId);

	public CategoryResponse save(CategoryRequest categoryRequest);

	public CategoryResponse update(CategoryUpdate categoryUpdate);
	
	public CategoryResponse setLeaf(LeafCategory leafCategory);
}
