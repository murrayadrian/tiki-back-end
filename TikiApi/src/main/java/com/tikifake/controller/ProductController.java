package com.tikifake.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tikifake.model.request.creator.ProductCreator;
import com.tikifake.model.request.update.ProductUpdate;
import com.tikifake.model.response.creator.ProductResponse;
import com.tikifake.model.response.detail.IProductDetail;
import com.tikifake.model.response.list.IProductList;
import com.tikifake.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long productId) {
		IProductDetail product = productService.getDetailById(productId);
		if (product == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Not Found");
		}
		return ResponseEntity.ok().body(product);
	}
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getAll(int page) {
		List<IProductList> products = productService.getAll(page);
		if (products == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		return ResponseEntity.ok().body(products);
	}
	
	
	@RequestMapping(value = "/getByCategorySubId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByCategorySubId(@PathVariable("id") Long id) {
		List<IProductDetail> response = productService.getByCategorySubId(id);
		return ResponseEntity.ok().body(response);
		
	}
	
	
	@RequestMapping(value = "/getByCategoryId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByCategoryId(@PathVariable("id") Long id) {
		Map<String,List<IProductDetail>> response = productService.getByCategoryId(id);
		return ResponseEntity.ok().body(response);	
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addProduct(@RequestBody ProductCreator productCreator) {
		ProductResponse productResponse = productService.save(productCreator);
		return ResponseEntity.ok().body(productResponse);
	}
	
	
	@RequestMapping(value = "/addList", method = RequestMethod.POST)
	public ResponseEntity<Object> addProductList(@RequestBody List<ProductCreator> productCreators) {
		List<ProductResponse> response = new ArrayList<>();
		for(ProductCreator productCreator : productCreators) {
			ProductResponse productResponse = productService.save(productCreator);
			response.add(productResponse);
		}
		return ResponseEntity.ok().body(response);
		
	}
	
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@RequestBody ProductUpdate productUpdate) {
		productService.update(productUpdate);
		return ResponseEntity.status(HttpStatus.OK).body("update successfully");
	}
}
