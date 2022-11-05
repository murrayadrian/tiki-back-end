package com.tikifake.service;

import java.util.List;

import com.tikifake.model.ICategorySub;
import com.tikifake.model.creator.CategorySubCreator;
import com.tikifake.model.response.CategorySubResponse;
import com.tikifake.model.update.CategorySubUpdate;

public interface CategorySubService {

	public ICategorySub getDetailById(Long id);
	
	public List<ICategorySub> getAll();
	
	public List<ICategorySub> getByCategoryId(Long id);
	
	public CategorySubResponse save(CategorySubCreator categorySubCreator);
	
	public CategorySubResponse update(CategorySubUpdate categorySubUpdate);
}
