package com.tikifake.service;

import java.util.List;
import java.util.Map;

import com.tikifake.model.ProductCreator;
import com.tikifake.model.response.ProductResponse;
import com.tikifake.model.update.ProductUpdate;
import com.tikifake.model.IProduct;


public interface ProductService {
	public IProduct getDetailById(Long productId);

	public List<IProduct> getAll();
	
	public List<IProduct> getByCategorySubId(Long id);
	
	public Map<String,List<IProduct>> getByCategoryId(Long id);

	public ProductResponse save(ProductCreator productcreator);

	public void update(ProductUpdate productUpdate);

	
}
