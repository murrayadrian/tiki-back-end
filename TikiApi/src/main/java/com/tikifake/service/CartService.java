package com.tikifake.service;

import java.util.List;

import com.tikifake.model.response.creator.CartDTO;
import com.tikifake.model.response.creator.CartItemCheckoutResponse;
import com.tikifake.model.response.creator.CartItemCreatorResponse;
import com.tikifake.model.response.list.ICart;
import com.tikifake.model.response.list.ICartItemList;

public interface CartService {

	public List<CartItemCreatorResponse> getAllItemInCart(Long cartId);
	
	public List<ICartItemList> findAllItemInCartDTO(Long cartId);
	
	public List<CartItemCheckoutResponse> checkout(Long cartId);
	
	public ICart getAllCartInfo(Long cartId);
	
	public CartDTO getEverything(Long cartId);
	
	public List<ICartItemList> findAllCheckedItemInCart(Long cartId);
}
