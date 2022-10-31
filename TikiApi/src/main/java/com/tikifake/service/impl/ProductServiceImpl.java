package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Category;
import com.tikifake.entity.Product;
import com.tikifake.model.ProductAddition;
import com.tikifake.model.ProductCreator;
import com.tikifake.model.IProduct;
import com.tikifake.repositoty.CategoryRepository;
import com.tikifake.repositoty.ProductRepository;
import com.tikifake.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public IProduct getDetailById(Long productId) {
		return productRepository.findByIdDTO(productId);
	}

	@Override
	public List<IProduct> getAll() {
		return productRepository.findAllDTO();
	}

	@Override
	public ProductAddition save(ProductCreator productCreator) {
		Category category = categoryRepository.findById(productCreator.getCategoryId()).get();
		Product product = productCreator.convertDTOToEntity(category);
		Product result = productRepository.save(product);
		ProductAddition productAdd = new ProductAddition(result);
		return productAdd;
	}

	@Override
	public Product update(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void delete(Long productId) {
		// TODO Auto-generated method stub
		
	}

}
