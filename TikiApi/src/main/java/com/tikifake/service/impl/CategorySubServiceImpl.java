//package com.tikifake.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.tikifake.entity.Category;
//import com.tikifake.entity.CategorySub;
//import com.tikifake.model.request.creator.CategorySubCreator;
//import com.tikifake.model.request.update.CategorySubUpdate;
//import com.tikifake.model.response.detail.ICategorySubDetail;
//import com.tikifake.repository.CategoryRepository;
//import com.tikifake.repository.CategorySubRepository;
//import com.tikifake.service.CategorySubService;
//
//@Service
//public class CategorySubServiceImpl implements CategorySubService{
//
//	@Autowired
//	private CategorySubRepository categorySubRepository;
//	
//	@Autowired
//	private CategoryRepository categoryRepository;
//	
//	@Override
//	public ICategorySubDetail getDetailById(Long id) {
//		return categorySubRepository.findByIdDTO(id);
//	}
//
//	@Override
//	public List<ICategorySubDetail> getAll() {
//		return categorySubRepository.findAllDTO();
//	}
//	@Override
//	public List<ICategorySubDetail> getByCategoryId(Long id) {
//		return categorySubRepository.findByCategoryId(id);
//	}
//
//	@Override
//	public CategorySubCreator save(CategorySubCreator categorySubCreator) {
//		Category category = categoryRepository.findById(categorySubCreator.getCategoryId()).get();
//		CategorySub categorySub = categorySubCreator.convertModelToEntity(category);
//		CategorySub result = categorySubRepository.save(categorySub);
//		CategorySubCreator response = new CategorySubCreator().convertEntityToResponse(result);
//		return response;
//	}
//
//	@Override
//	public CategorySubCreator update(CategorySubUpdate categorySubUpdate) {
//		Category category = categoryRepository.findById(categorySubUpdate.getCategoryId()).get();
//		CategorySub categorySub = categorySubUpdate.convertToEntity(category);
//		CategorySub result = categorySubRepository.save(categorySub);
//		CategorySubCreator response = new CategorySubCreator().convertEntityToResponse(result);
//		return response;
//	}
//
//}
