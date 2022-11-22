package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.CartItemCreatorRequest;
import com.tikifake.model.request.creator.CartItemIdRequest;
import com.tikifake.model.request.creator.CartItemInfoRequest;
import com.tikifake.model.request.creator.CheckItemRequest;
import com.tikifake.model.response.creator.CartItemCreatorResponse;
import com.tikifake.model.response.list.ICartItemList;

public interface CartItemService {

	public CartItemCreatorResponse addProductToCart(CartItemCreatorRequest cartItemCreatorRequest);

	public void removeProductFromCart(CartItemIdRequest cartItemIdRequest);
	
	//
	public List<ICartItemList> checkItem(CheckItemRequest info);

	public CartItemCreatorResponse unCheckItem(CartItemIdRequest info);
	
	//
	public CartItemCreatorResponse changeQuantity(CartItemInfoRequest info);
	
	//
	public List<CartItemCreatorResponse> checkAllItem(Long cartId);

	public List<CartItemCreatorResponse> unCheckAllItem(Long cartId);

	public void removeAllCheckedItem(Long cartId);
}
