package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Category;
import com.tikifake.entity.CategorySub;
import com.tikifake.model.ICategorySub;
import com.tikifake.model.creator.CategorySubCreator;
import com.tikifake.repositoty.CategoryRepository;
import com.tikifake.repositoty.CategorySubRepository;
import com.tikifake.service.CategorySubService;

@Service
public class CategorySubServiceImpl implements CategorySubService{

	@Autowired
	private CategorySubRepository categorySubRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public ICategorySub getDetailById(Long categoryBrandId) {
		return categorySubRepository.findByIdDTO(categoryBrandId);
	}

	@Override
	public List<ICategorySub> getAll() {
		return categorySubRepository.findAllDTO();
	}

	@Override
	public CategorySub save(CategorySubCreator categorySubCreator) {
		Category category = categoryRepository.findById(categorySubCreator.getCategoryId()).get();
		CategorySub categoryBrand = categorySubCreator.convertModelToEntity(category);
		return categorySubRepository.save(categoryBrand);
	}

	@Override
	public CategorySub update(CategorySub categoryBrand) {
		// TODO Auto-generated method stub
		return null;
	}

}
