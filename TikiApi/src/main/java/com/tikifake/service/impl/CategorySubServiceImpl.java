package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Category;
import com.tikifake.entity.CategorySub;
import com.tikifake.model.ICategorySub;
import com.tikifake.model.creator.CategorySubCreator;
import com.tikifake.model.response.CategorySubResponse;
import com.tikifake.model.update.CategorySubUpdate;
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
	public ICategorySub getDetailById(Long id) {
		return categorySubRepository.findByIdDTO(id);
	}

	@Override
	public List<ICategorySub> getAll() {
		return categorySubRepository.findAllDTO();
	}
	@Override
	public List<ICategorySub> getByCategoryId(Long id) {
		return categorySubRepository.findByCategoryId(id);
	}

	@Override
	public CategorySubResponse save(CategorySubCreator categorySubCreator) {
		Category category = categoryRepository.findById(categorySubCreator.getCategoryId()).get();
		CategorySub categorySub = categorySubCreator.convertModelToEntity(category);
		CategorySub result = categorySubRepository.save(categorySub);
		CategorySubResponse response = new CategorySubResponse().convertEntityToResponse(result);
		return response;
	}

	@Override
	public CategorySubResponse update(CategorySubUpdate categorySubUpdate) {
		Category category = categoryRepository.findById(categorySubUpdate.getCategoryId()).get();
		CategorySub categorySub = categorySubUpdate.convertToEntity(category);
		CategorySub result = categorySubRepository.save(categorySub);
		CategorySubResponse response = new CategorySubResponse().convertEntityToResponse(result);
		return response;
	}

}
