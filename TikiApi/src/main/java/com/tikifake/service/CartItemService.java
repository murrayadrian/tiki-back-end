package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.CartItemCreatorRequest;
import com.tikifake.model.request.creator.CartItemInfoRequest;
import com.tikifake.model.response.creator.CartItemCreatorResponse;

public interface CartItemService {

	public CartItemCreatorResponse addProductToCart(CartItemCreatorRequest cartItemCreatorRequest);

	public void removeProductFromCart(CartItemInfoRequest cartItemInfoRequest);
	
	//
	public CartItemCreatorResponse checkItem(CartItemInfoRequest info);

	public CartItemCreatorResponse unCheckItem(CartItemInfoRequest info);
	
	//
	public CartItemCreatorResponse increaseByOne(CartItemInfoRequest info);

	public CartItemCreatorResponse decreaseByOne(CartItemInfoRequest info);
	
	//
	public List<CartItemCreatorResponse> checkAllItem(Long cartId);

	public List<CartItemCreatorResponse> unCheckAllItem(Long cartId);

	public void removeAllCheckedItem(Long cartId);
}
