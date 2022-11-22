package com.tikifake.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tikifake.entity.Cart;
import com.tikifake.entity.CartItem;
import com.tikifake.entity.Product;
import com.tikifake.model.request.creator.CartItemCreatorRequest;
import com.tikifake.model.request.creator.CartItemIdRequest;
import com.tikifake.model.request.creator.CartItemInfoRequest;
import com.tikifake.model.request.creator.CheckItemRequest;
import com.tikifake.model.response.creator.CartItemCreatorResponse;
import com.tikifake.model.response.list.ICartItemList;
import com.tikifake.repository.CartItemRepository;
import com.tikifake.repository.CartRepository;
import com.tikifake.repository.ProductRepository;
import com.tikifake.service.CartItemService;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	@Override
	public CartItemCreatorResponse addProductToCart(CartItemCreatorRequest cartItemCreatorRequest) {

		Long productId = cartItemCreatorRequest.getProductId();
		Long cartId = cartItemCreatorRequest.getCartId();
		int orderQuantity = cartItemCreatorRequest.getOrderQuantity();

		CartItem cartItemExist = cartItemRepository.findByIdProductIdAndIdCartId(productId, cartId);

		if (cartItemExist != null) {
			cartItemExist = cartItemCreatorRequest.updateExistedCartItem(cartItemExist, orderQuantity);
			CartItem result = cartItemRepository.save(cartItemExist);
			CartItemCreatorResponse response = new CartItemCreatorResponse(result);
			return response;
		}

		Cart cart = cartRepository.findById(cartId).get();

		Product product = productRepository.findById(productId).get();

		CartItem cartItem = cartItemCreatorRequest.convertToEntity(product, cart);

		CartItem result = cartItemRepository.save(cartItem);

		CartItemCreatorResponse response = new CartItemCreatorResponse(result);

		return response;
	}

	@Override
	public void removeProductFromCart(CartItemIdRequest cartItemIdRequest) {
		Long productId = cartItemIdRequest.getProductId();
		Long cartId = cartItemIdRequest.getCartId();

		cartItemRepository.deleteByIdProductIdAndIdCartId(productId, cartId);
	}

	@Override
	public List<ICartItemList> checkItem(CheckItemRequest info) {
		CartItem cartItem = cartItemRepository.findByIdProductIdAndIdCartId(info.getProductId(), info.getCartId());
		cartItem.setCheck(info.isCheck());
		cartItemRepository.save(cartItem);
		List<ICartItemList> items = cartItemRepository.findAllCheckedItemInCartDTO(info.getCartId());
//		CartItemCreatorResponse response = new CartItemCreatorResponse(result);
		return items;
	}

	@Override
	public CartItemCreatorResponse unCheckItem(CartItemIdRequest info) {
		CartItem cartItem = cartItemRepository.findByIdProductIdAndIdCartId(info.getProductId(), info.getCartId());
		cartItem.setCheck(false);
		CartItem result = cartItemRepository.save(cartItem);
		CartItemCreatorResponse response = new CartItemCreatorResponse(result);
		return response;
	}

	@Override
	public CartItemCreatorResponse changeQuantity(CartItemInfoRequest info) {
		CartItem cartItem = cartItemRepository.findByIdProductIdAndIdCartId(info.getProductId(), info.getCartId());
		int newQuantity = cartItem.getQuantity() + info.getQuantity();
		double productPrice = cartItem.getProduct().getPrice();
		double productWeight = cartItem.getProduct().getWeight();
		
		cartItem.setQuantity(newQuantity);
		cartItem.setTotalPrice(newQuantity * productPrice);
		cartItem.setTotalWeight(newQuantity * productWeight);

		CartItem result = cartItemRepository.save(cartItem);
		CartItemCreatorResponse response = new CartItemCreatorResponse(result);
		return response;
	}


	@Override
	public List<CartItemCreatorResponse> checkAllItem(Long cartId) {
		List<CartItem> cartItems = cartItemRepository.findAllItemInCart(cartId);
		List<CartItemCreatorResponse> response = new ArrayList<>();
		for(CartItem item : cartItems) {
			item.setCheck(true);
			CartItem result = cartItemRepository.save(item);
			CartItemCreatorResponse res = new CartItemCreatorResponse(result);
			response.add(res);
		}
		return response;
	}

	@Override
	public List<CartItemCreatorResponse> unCheckAllItem(Long cartId) {
		List<CartItem> cartItems = cartItemRepository.findAllItemInCart(cartId);
		List<CartItemCreatorResponse> response = new ArrayList<>();
		for(CartItem item : cartItems) {
			item.setCheck(false);
			CartItem result = cartItemRepository.save(item);
			CartItemCreatorResponse res = new CartItemCreatorResponse(result);
			response.add(res);
		}
		return response;
	}

	@Override
	public void removeAllCheckedItem(Long cartId) {
		cartItemRepository.deleteAllCheckedItem(cartId);
		
	}

}
