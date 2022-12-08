package com.tikifake.service;

import com.tikifake.model.request.creator.CartItemCreatorRequest;
import com.tikifake.model.request.creator.RemoveProductRequest;
import com.tikifake.model.request.creator.CartItemInfoRequest;
import com.tikifake.model.request.creator.CheckItemRequest;
import com.tikifake.model.request.creator.ShopCheckRequest;
import com.tikifake.model.response.creator.CartItemCreatorResponse;
import com.tikifake.model.response.creator.ChangeQuantityResponse;
import com.tikifake.model.response.creator.FinalPriceResponse;

public interface CartItemService {

	public CartItemCreatorResponse addProductToCart(CartItemCreatorRequest cartItemCreatorRequest);

	public FinalPriceResponse removeProductFromCart(RemoveProductRequest removeProductRequest);
	
	//
	public FinalPriceResponse checkItem(CheckItemRequest info);

	public FinalPriceResponse checkAllItemInShop(ShopCheckRequest info);
	
	//
	public ChangeQuantityResponse changeQuantity(CartItemInfoRequest info);
	
	//
	public FinalPriceResponse checkAllItem(Long cartId);

	public void removeAllCheckedItem(Long cartId);
}
