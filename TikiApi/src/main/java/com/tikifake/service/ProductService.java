package com.tikifake.service;

import java.util.List;
import java.util.Map;

import com.tikifake.model.request.creator.ProductCreator;
import com.tikifake.model.request.update.ProductUpdate;
import com.tikifake.model.response.creator.ProductResponse;
import com.tikifake.model.response.detail.IProductDetail;
import com.tikifake.model.response.list.IProductList;


public interface ProductService {
	public IProductDetail getDetailById(Long productId);

	public List<IProductList> getAll(int page, String sort);
	
	public List<IProductDetail> getByCategorySubId(Long id, int page, String sort);
	
	public Map<String,List<IProductDetail>> getByCategoryId(Long id, int page, String sort);

	public ProductResponse save(ProductCreator productcreator);

	public void update(ProductUpdate productUpdate);

	
}
