package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.CategorySubCreator;
import com.tikifake.model.request.update.CategorySubUpdate;
import com.tikifake.model.response.creator.CategorySubResponse;
import com.tikifake.model.response.detail.ICategorySubDetail;

public interface CategorySubService {

	public ICategorySubDetail getDetailById(Long id);
	
	public List<ICategorySubDetail> getAll();
	
	public List<ICategorySubDetail> getByCategoryId(Long id);
	
	public CategorySubResponse save(CategorySubCreator categorySubCreator);
	
	public CategorySubResponse update(CategorySubUpdate categorySubUpdate);
}
