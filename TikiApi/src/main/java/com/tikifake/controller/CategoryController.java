package com.tikifake.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tikifake.model.request.creator.CategoryRequest;
import com.tikifake.model.request.update.CategoryUpdate;
import com.tikifake.model.request.update.LeafCategory;
import com.tikifake.model.response.creator.CategoryResponse;
import com.tikifake.model.response.detail.ICategoryDetail;
import com.tikifake.model.response.list.ICategoryList;
import com.tikifake.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/getCategoryById/{id}")
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long categoryId) {
		ICategoryDetail category = categoryService.getDetailById(categoryId);
		if (category == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category Not Found");
		}
		return ResponseEntity.ok().body(category);
	}

	@GetMapping("/getLevel1Category")
	public ResponseEntity<Object> getLevel1Category() {
		List<ICategoryList> categories = categoryService.getLevel1Category(1);
		if (categories == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping("/getSubCategory/{parentId}")
	public ResponseEntity<Object> getSubCategory(@PathVariable(value = "parentId") Long parentId) {
		List<ICategoryList> categories = categoryService.getSubCategory(parentId);
		if (categories == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping("/getAllCategory")
	public ResponseEntity<Object> getAllCategory() {
		List<ICategoryList> categories = categoryService.getAll();
		if (categories == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		return ResponseEntity.ok().body(categories);
	}
	
	@PostMapping("/addCategory")
	public ResponseEntity<Object> addCategory(@RequestBody CategoryRequest categoryRequest) {
		CategoryResponse categoryResponse = categoryService.save(categoryRequest);
		return ResponseEntity.ok().body(categoryResponse);
	}
	
	@PostMapping("/addListCategories")
	public ResponseEntity<Object> addList(@RequestBody List<CategoryRequest> categoryRequests){
		List<CategoryResponse> response = new ArrayList<>();
		
		for(CategoryRequest categoryRequest : categoryRequests) {
			CategoryResponse categoryResponse = categoryService.save(categoryRequest);
			response.add(categoryResponse);
		}
		if (response.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		
		return ResponseEntity.ok().body(response);	
	}
	
	@PutMapping("/updateCategory")
	public ResponseEntity<Object> update(@RequestBody CategoryUpdate categoryUpdate){
		CategoryResponse categoryResponse = categoryService.update(categoryUpdate);
		
		if (categoryResponse == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		
		return ResponseEntity.ok().body(categoryResponse);	
	}
	@PutMapping("/setLeafCategory")
	public ResponseEntity<Object> setLeaf(@RequestBody List<LeafCategory> leafCategories){
		List<CategoryResponse> response = new ArrayList<>();
		for(LeafCategory leafCategory : leafCategories) {
			CategoryResponse categoryResponse = categoryService.setLeaf(leafCategory);
			response.add(categoryResponse);
		}
		if (response.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		
		return ResponseEntity.ok().body(response);	
	}
}

