package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Category;
import com.tikifake.model.request.creator.CategoryCreator;
import com.tikifake.model.request.update.CategoryUpdate;
import com.tikifake.model.response.detail.ICategoryDetail;
import com.tikifake.model.response.list.ICategoryList;
import com.tikifake.repository.CategoryRepository;
import com.tikifake.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private final int SIZE = 5;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public ICategoryDetail getDetailById(Long categoryId) {
		return categoryRepository.findByIdDTO(categoryId);
	}

	@Override
	public List<ICategoryList> getAll(int page) {
		Pageable pageable = PageRequest.of(page, SIZE, Sort.by("name").descending());
		List<ICategoryList> findAllCategory = categoryRepository.findAllCategory(pageable);
		return findAllCategory;
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
