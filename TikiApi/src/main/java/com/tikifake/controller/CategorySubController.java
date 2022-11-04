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

import com.tikifake.entity.CategorySub;
import com.tikifake.model.ICategorySub;
import com.tikifake.model.creator.CategorySubCreator;
import com.tikifake.service.CategorySubService;

@RestController
@RequestMapping("/categorysub")
public class CategorySubController {

	@Autowired
	private CategorySubService categorySubService;

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long categorySubId) {
		ICategorySub categorySub = categorySubService.getDetailById(categorySubId);
		if (categorySub == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category Not Found");
		}
		return ResponseEntity.ok().body(categorySub);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getAll() {
		List<ICategorySub> categoriesSub = categorySubService.getAll();
		if (categoriesSub == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		return ResponseEntity.ok().body(categoriesSub);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addCategory(@RequestBody CategorySubCreator categorySubCreator) {
		CategorySub categorySub = categorySubService.save(categorySubCreator);
		return ResponseEntity.ok().body(categorySub);
	}

}
