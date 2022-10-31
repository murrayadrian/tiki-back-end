package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Category;
import com.tikifake.model.CategoryCreator;
import com.tikifake.model.ICategory;
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
	public Category save(CategoryCreator categoryCreator) {
		Category category = categoryCreator.convertDTOToEntity();
		return categoryRepository.save(category);
	}

	@Override
	public Category update(Category category) {
		return categoryRepository.save(category);
	}

}
