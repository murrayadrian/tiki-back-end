package com.tikifake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tikifake.entity.Category;
import com.tikifake.model.CategoryCreator;
import com.tikifake.model.ICategory;
import com.tikifake.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long productId) {
		ICategory category = categoryService.getDetailById(productId);
		if (category == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category Not Found");
		}
		return ResponseEntity.ok().body(category);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getAll() {
		List<ICategory> categories = categoryService.getAll();
		if (categories == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		return ResponseEntity.ok().body(categories);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addCategory(@RequestBody CategoryCreator categoryCreator) {
		Category category = categoryService.save(categoryCreator);
		return ResponseEntity.ok().body(category);
	}
}
