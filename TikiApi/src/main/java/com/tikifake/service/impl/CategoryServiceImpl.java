package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Category;
import com.tikifake.model.ICategory;
import com.tikifake.model.creator.CategoryCreator;
import com.tikifake.model.response.CategoryResponse;
import com.tikifake.model.update.CategoryUpdate;
import com.tikifake.repositoty.CategoryRepository;
import com.tikifake.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public ICategory getDetailById(Long categoryId) {
		return categoryRepository.findByIdDTO(categoryId);
	}

	@Override
	public List<ICategory> getAll() {
		return categoryRepository.findAllDTO();
	}

	@Override
	public CategoryResponse save(CategoryCreator categoryCreator) {
		Category category = categoryCreator.convertDTOToEntity();
		Category result = categoryRepository.save(category);
		CategoryResponse categoryResponse = new CategoryResponse().convertEntityToResponse(result);
		return categoryResponse;
	}

	@Override
	public CategoryResponse update(CategoryUpdate categoryUpdate) {
		Category category = categoryUpdate.convertUpdateToEntity();
		Category result = categoryRepository.save(category);
		CategoryResponse categoryResponse = new CategoryResponse().convertEntityToResponse(result);
		return categoryResponse;
	}

}
