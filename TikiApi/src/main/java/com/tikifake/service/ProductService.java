package com.tikifake.service;

import java.util.List;
import java.util.Map;

import com.tikifake.model.request.creator.ProductCreator;
import com.tikifake.model.request.update.ProductUpdate;
import com.tikifake.model.response.creator.ProductResponse;
import com.tikifake.model.response.detail.IProductDetail;


public interface ProductService {
	public IProductDetail getDetailById(Long productId);

	public List<IProductDetail> getAll();
	
	public List<IProductDetail> getByCategorySubId(Long id);
	
	public Map<String,List<IProductDetail>> getByCategoryId(Long id);

	public ProductResponse save(ProductCreator productcreator);

	public void update(ProductUpdate productUpdate);

	
}
