package com.tikifake.service;

import java.util.List;

import com.tikifake.entity.Product;
import com.tikifake.model.ProductAddition;
import com.tikifake.model.ProductCreator;
import com.tikifake.model.IProduct;


public interface ProductService {
	public IProduct getDetailById(Long productId);

	public List<IProduct> getAll();

	public ProductAddition save(ProductCreator productcreator);

	public Product update(Product product);

	public void delete(Long productId);
}
