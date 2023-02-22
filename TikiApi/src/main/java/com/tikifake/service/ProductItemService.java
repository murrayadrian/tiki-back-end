package com.tikifake.service;

import com.tikifake.model.request.creator.AddProductRequest;
import com.tikifake.model.response.creator.AddProductResponse;

public interface ProductItemService {
	
	public AddProductResponse addProduct(AddProductRequest addProductRequest);
}
