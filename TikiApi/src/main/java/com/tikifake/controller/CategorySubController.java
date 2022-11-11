//package com.tikifake.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tikifake.model.request.creator.CategorySubCreator;
//import com.tikifake.model.request.update.CategorySubUpdate;
//import com.tikifake.model.response.creator.CategorySubCreator;
//import com.tikifake.model.response.detail.ICategorySubDetail;
//import com.tikifake.service.CategorySubService;
//
//@RestController
//@RequestMapping("/categorySub")
//public class CategorySubController {
//
//	@Autowired
//	private CategorySubService categorySubService;
//
//	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long categorySubId) {
//		ICategorySubDetail categorySub = categorySubService.getDetailById(categorySubId);
//		if (categorySub == null) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category Not Found");
//		}
//		return ResponseEntity.ok().body(categorySub);
//	}
//
//	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
//	public ResponseEntity<Object> getAll() {
//		List<ICategorySubDetail> categoriesSub = categorySubService.getAll();
//		if (categoriesSub == null) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
//		}
//		return ResponseEntity.ok().body(categoriesSub);
//	}
//	
//	
//	@RequestMapping(value = "/getByCategoryId/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Object> getByCategoryId(@PathVariable("id") Long id) {
//		List<ICategorySubDetail> response = categorySubService.getByCategoryId(id);
//		if (response.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
//		}
//		return ResponseEntity.ok().body(response);
//		
//	}
//
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public ResponseEntity<Object> addCategorySub(@RequestBody CategorySubCreator categorySubCreator) {
//		CategorySubCreator response = categorySubService.save(categorySubCreator);
//		return ResponseEntity.ok().body(response);
//	}
//	
//	
//	@RequestMapping(value = "/addList", method = RequestMethod.POST)
//	public ResponseEntity<Object> addList(@RequestBody List<CategorySubCreator> categorySubCreatorList) {
//		List<CategorySubCreator> responseList = new ArrayList<>();
//		for(CategorySubCreator categorySubCreator : categorySubCreatorList) {
//			CategorySubCreator response = categorySubService.save(categorySubCreator);
//			responseList.add(response);
//		}
//		return ResponseEntity.ok().body(responseList);
//	}
//	@RequestMapping(value = "/update", method = RequestMethod.PUT)
//	public ResponseEntity<Object> updateCategorySub(@RequestBody CategorySubUpdate categorySubUpdate) {
//		CategorySubCreator response = categorySubService.update(categorySubUpdate);
//		return ResponseEntity.ok().body(response);	
//	}
//	
//
//}
