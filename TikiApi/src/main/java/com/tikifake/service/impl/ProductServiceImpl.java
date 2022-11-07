package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.CategorySub;
import com.tikifake.entity.Product;
import com.tikifake.model.IProduct;
import com.tikifake.model.creator.ProductCreator;
import com.tikifake.model.response.ProductAddition;
import com.tikifake.repositoty.CategorySubRepository;
import com.tikifake.repositoty.ProductRepository;
import com.tikifake.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategorySubRepository categorySubRepository;
	
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
		CategorySub categoryModel = categorySubRepository.findById(productCreator.getCategorySubId()).get();
		Product product = productCreator.convertDTOToEntity(categoryModel);
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
