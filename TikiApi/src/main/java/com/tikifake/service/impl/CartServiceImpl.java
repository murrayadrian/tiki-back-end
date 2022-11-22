package com.tikifake.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Cart;
import com.tikifake.entity.CartItem;
import com.tikifake.model.response.creator.CartDTO;
import com.tikifake.model.response.creator.CartItemCheckoutResponse;
import com.tikifake.model.response.creator.CartItemCreatorResponse;
import com.tikifake.model.response.detail.IUserDetail;
import com.tikifake.model.response.list.ICart;
import com.tikifake.model.response.list.ICartItemList;
import com.tikifake.repository.CartItemRepository;
import com.tikifake.repository.CartRepository;
import com.tikifake.repository.UserRepository;
import com.tikifake.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	

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


	@Override
	public List<ICartItemList> findAllItemInCartDTO(Long cartId) {
		return cartItemRepository.findAllItemInCartDTO(cartId);
	}


	@Override
	public ICart getAllCartInfo(Long cartId) {
		return cartRepository.getAllCartInfo(cartId);
	}


	@Override
	public CartDTO getEverything(Long cartId) {
		Cart cart = cartRepository.findById(cartId).get();
		Long userId = cart.getUser().getId();
	
		List<ICartItemList> cartItems = cartItemRepository.findAllItemInCartDTO(cartId);
		ICart cartInfo = cartRepository.getAllCartInfo(cartId);
		IUserDetail userInfo = userRepository.findByIdDTO(userId);
		
		CartDTO cartDTO = new CartDTO();
		cartDTO.setCartInfo(cartInfo);
		cartDTO.setUserInfo(userInfo);
		cartDTO.setCartItems(cartItems);
		
		return cartDTO;
	}


	@Override
	public List<ICartItemList> findAllCheckedItemInCart(Long cartId) {
		return cartItemRepository.findAllCheckedItemInCartDTO(cartId);
	}

}
