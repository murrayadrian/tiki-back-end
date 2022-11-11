//package com.tikifake.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.tikifake.entity.Category;
//import com.tikifake.model.request.creator.CategoryCreator;
//import com.tikifake.model.request.update.CategoryUpdate;
//import com.tikifake.model.response.creator.CategoryCreator;
//import com.tikifake.model.response.detail.ICategoryDetail;
//import com.tikifake.repository.CategoryRepository;
//import com.tikifake.service.CategoryService;
//
//@Service
//public class CategoryServiceImpl implements CategoryService {
//
//	@Autowired
//	private CategoryRepository categoryRepository;
//	
//	@Override
//	public ICategoryDetail getDetailById(Long categoryId) {
//		return categoryRepository.findByIdDTO(categoryId);
//	}
//
//	@Override
//	public List<ICategoryDetail> getAll() {
//		return categoryRepository.findAllDTO();
//	}
//
//	@Override
//	public CategoryCreator save(CategoryCreator categoryCreator) {
//		Category category = categoryCreator.convertDTOToEntity();
//		Category result = categoryRepository.save(category);
//		CategoryCreator categoryResponse = new CategoryCreator().convertEntityToResponse(result);
//		return categoryResponse;
//	}
//
//	@Override
//	public CategoryCreator update(CategoryUpdate categoryUpdate) {
//		Category category = categoryUpdate.convertUpdateToEntity();
//		Category result = categoryRepository.save(category);
//		CategoryCreator categoryResponse = new CategoryCreator().convertEntityToResponse(result);
//		return categoryResponse;
//	}
//
//}
