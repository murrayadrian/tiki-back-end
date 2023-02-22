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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tikifake.model.request.creator.ProductCreator;
import com.tikifake.model.request.update.ProducInfoUpdate;
import com.tikifake.model.response.creator.ProductResponse;
import com.tikifake.model.response.creator.ProductSaveResponse;
import com.tikifake.model.response.detail.IProductDetail;
import com.tikifake.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/getProductById/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable(value = "id") Long productId) {
		IProductDetail product = productService.getDetailById(productId);
		if (product == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Not Found");
		}
		return ResponseEntity.ok().body(product);
	}
	
	
	@GetMapping("/getAllProduct")
	public ResponseEntity<Object> getAllProduct(@RequestParam int page, @RequestParam int limit) {
		List<ProductResponse> products = productService.getAll(page, limit);
		if (products == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		return ResponseEntity.ok().body(products);
	}
	
	
	@GetMapping("/getAllByCategoryId/{id}")
	public ResponseEntity<Object> getAllByCategoryId(@PathVariable("id") Long id) {
		List<IProductDetail> response = productService.getAllByCategoryId(id);
		return ResponseEntity.ok().body(response);
		
	}
	
//	
//	@RequestMapping(value = "/getByCategoryId/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Object> getByCategoryId(@PathVariable("id") Long id) {
//		Map<String,List<IProductDetail>> response = productService.getByCategoryId(id);
//		return ResponseEntity.ok().body(response);	
//	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Object> addProduct(@RequestBody ProductCreator productCreator) {
		ProductSaveResponse response = productService.save(productCreator);
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("/addList")
	public ResponseEntity<Object> addProductList(@RequestBody List<ProductCreator> productCreators) {
		List<ProductSaveResponse> response = new ArrayList<>();
		for(ProductCreator productCreator : productCreators) {
			ProductSaveResponse productResponse = productService.save(productCreator);
			response.add(productResponse);
		}
		return ResponseEntity.ok().body(response);
		
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateProduct(@RequestBody ProducInfoUpdate producInfoUpdate) {
		productService.updateInfo(producInfoUpdate);
		return ResponseEntity.status(HttpStatus.OK).body("update successfully");
	}
}
