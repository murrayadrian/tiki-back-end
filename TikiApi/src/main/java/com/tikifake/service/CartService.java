package com.tikifake.service;

import java.util.List;

import com.tikifake.model.response.creator.CartItemCheckoutResponse;
import com.tikifake.model.response.creator.CartItemCreatorResponse;

public interface CartService {

	public List<CartItemCreatorResponse> getAllItemInCart(Long cartId);

	public List<CartItemCheckoutResponse> checkout(Long cartId);

}
