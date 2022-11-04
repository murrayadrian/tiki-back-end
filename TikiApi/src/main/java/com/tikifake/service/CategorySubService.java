package com.tikifake.service;

import java.util.List;

import com.tikifake.entity.CategorySub;
import com.tikifake.model.ICategorySub;
import com.tikifake.model.creator.CategorySubCreator;

public interface CategorySubService {

	public ICategorySub getDetailById(Long categoryBrandId);
	
	public List<ICategorySub> getAll();
	
	public CategorySub save(CategorySubCreator categoryBrandCreator);
	
	public CategorySub update(CategorySub categoryBrand);
}
