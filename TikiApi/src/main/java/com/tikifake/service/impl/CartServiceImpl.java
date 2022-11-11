package com.tikifake.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.CartItem;
import com.tikifake.model.response.creator.CartItemCheckoutResponse;
import com.tikifake.model.response.creator.CartItemCreatorResponse;
import com.tikifake.repository.CartItemRepository;
import com.tikifake.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public List<CartItemCreatorResponse> getAllItemInCart(Long cartId) {
		List<CartItem> cartItems = cartItemRepository.findAllItemInCart(cartId);
		List<CartItemCreatorResponse> response = new ArrayList<>();
		for (CartItem cartItem : cartItems) {
			CartItemCreatorResponse res = new CartItemCreatorResponse(cartItem);
			response.add(res);
		}
		return response;
	}


	@Override
	public List<CartItemCheckoutResponse> checkout(Long cartId) {
		List<CartItem> checkoutList = cartItemRepository.findAllCheckedItemInCart(cartId);
		List<CartItemCheckoutResponse> checkoutResponse = new ArrayList<>();
		
		if(!checkoutList.isEmpty()) {
			for (CartItem item : checkoutList) {
				CartItemCheckoutResponse response = new CartItemCheckoutResponse(item);
				checkoutResponse.add(response);
			}
		}
		
		return checkoutResponse;
	}

}
