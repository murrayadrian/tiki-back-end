package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Category;
import com.tikifake.entity.CategorySub;
import com.tikifake.model.request.creator.CategorySubCreator;
import com.tikifake.model.request.update.CategorySubUpdate;
import com.tikifake.model.response.creator.CategorySubResponse;
import com.tikifake.model.response.detail.ICategorySubDetail;

import com.tikifake.model.response.list.ICategorySubList;

import com.tikifake.repository.CategoryRepository;
import com.tikifake.repository.CategorySubRepository;
import com.tikifake.service.CategorySubService;

@Service
public class CategorySubServiceImpl implements CategorySubService{
	
	private final int SIZE = 5;

	@Autowired
	private CategorySubRepository categorySubRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public ICategorySubDetail getDetailById(Long id) {
		return categorySubRepository.findByIdDTO(id);
	}

	@Override
	public List<ICategorySubList> getAll(int page) {
		Pageable pageable = PageRequest.of(page, SIZE, Sort.by("name").descending());
		return categorySubRepository.findAllDTO(pageable);
	}
	@Override
	public List<ICategorySubDetail> getByCategoryId(Long id) {
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