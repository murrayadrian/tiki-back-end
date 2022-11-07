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

import com.tikifake.model.response.ProductAddition;
import com.tikifake.model.IProduct;
import com.tikifake.model.creator.ProductCreator;
import com.tikifake.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long productId) {
		IProduct product = productService.getDetailById(productId);
		if (product == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Not Found");
		}
		return ResponseEntity.ok().body(product);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getAll() {
		List<IProduct> products = productService.getAll();
		if (products == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
		return ResponseEntity.ok().body(products);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addProduct(@RequestBody ProductCreator productCreator) {
		ProductAddition product = productService.save(productCreator);
		return ResponseEntity.ok().body(product);
	}
}
