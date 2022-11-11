package com.tikifake.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tikifake.model.request.creator.CategoryCreator;
import com.tikifake.model.request.update.CategoryUpdate;
import com.tikifake.model.response.creator.CategoryResponse;
import com.tikifake.model.response.detail.ICategoryDetail;
import com.tikifake.model.response.list.ICategoryList;
import com.tikifake.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long categoryId) {
		ICategoryDetail category = categoryService.getDetailById(categoryId);
		if (category == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category Not Found");
		}
		return ResponseEntity.ok().body(category);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getAll(int page) {
		List<ICategoryList> categories = categoryService.getAll(page);
		if (categories == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		return ResponseEntity.ok().body(categories);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addCategory(@RequestBody CategoryCreator categoryCreator) {
		CategoryResponse categoryResponse = categoryService.save(categoryCreator);
		return ResponseEntity.ok().body(categoryResponse);
	}
	
	@RequestMapping(value = "/addList", method = RequestMethod.POST)
	public ResponseEntity<Object> addList(@RequestBody List<CategoryCreator> categoryCreators){
		List<CategoryResponse> response = new ArrayList<>();
		
		for(CategoryCreator categoryCreator : categoryCreators) {
			CategoryResponse categoryResponse = categoryService.save(categoryCreator);
			response.add(categoryResponse);
		}
		if (response.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		
		return ResponseEntity.ok().body(response);	
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody CategoryUpdate categoryUpdate){
		CategoryResponse categoryResponse = categoryService.update(categoryUpdate);
		
		if (categoryResponse == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		
		return ResponseEntity.ok().body(categoryResponse);	
	}
}
