package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.CategorySubCreator;
import com.tikifake.model.request.update.CategorySubUpdate;
import com.tikifake.model.response.detail.ICategorySubDetail;
import com.tikifake.model.response.list.ICategorySubList;

public interface CategorySubService {

	public ICategorySubDetail getDetailById(Long id);
	
	public List<ICategorySubList> getAll(int page);
	
	public List<ICategorySubDetail> getByCategoryId(Long id);
	
	public CategorySubCreator save(CategorySubCreator categorySubCreator);
	
	public CategorySubCreator update(CategorySubUpdate categorySubUpdate);
}
