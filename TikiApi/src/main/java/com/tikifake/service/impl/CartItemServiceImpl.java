package com.tikifake.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tikifake.entity.Cart;
import com.tikifake.entity.CartItem;
import com.tikifake.entity.ProductItem;
import com.tikifake.model.request.creator.CartItemCreatorRequest;
import com.tikifake.model.request.creator.CartItemInfoRequest;
import com.tikifake.model.request.creator.CheckItemRequest;
import com.tikifake.model.request.creator.RemoveProductRequest;
import com.tikifake.model.request.creator.ShopCheckRequest;
import com.tikifake.model.response.creator.CartItemCreatorResponse;
import com.tikifake.model.response.creator.ChangeQuantityResponse;
import com.tikifake.model.response.creator.FinalPriceResponse;
import com.tikifake.model.response.list.ICartItemList;
import com.tikifake.model.response.list.IProductId;
import com.tikifake.repository.CartItemRepository;
import com.tikifake.repository.CartRepository;
import com.tikifake.repository.ProductItemRepository;
import com.tikifake.repository.ProductRepository;
import com.tikifake.repository.ShopRepository;
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

	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private ProductItemRepository productItemRepository;

	@Override
	public CartItemCreatorResponse addProductToCart(CartItemCreatorRequest cartItemCreatorRequest) {

		Long productItemId = cartItemCreatorRequest.getProductItemId();
		Long cartId = cartItemCreatorRequest.getCartId();
		int orderQuantity = cartItemCreatorRequest.getOrderQuantity();

		CartItem cartItemExist = cartItemRepository.findByIdProductItemIdAndIdCartId(productItemId, cartId);

		if (cartItemExist != null) {
			cartItemExist = cartItemCreatorRequest.updateExistedCartItem(cartItemExist, orderQuantity);
			CartItem result = cartItemRepository.save(cartItemExist);
			CartItemCreatorResponse response = new CartItemCreatorResponse(result);
			return response;
		}

		Cart cart = cartRepository.findById(cartId).get();

		ProductItem productItem = productItemRepository.findById(productItemId).get();

		CartItem cartItem = cartItemCreatorRequest.convertToEntity(productItem, cart);

		CartItem result = cartItemRepository.save(cartItem);

		CartItemCreatorResponse response = new CartItemCreatorResponse(result);

		return response;
	}

	@Override
	public FinalPriceResponse removeProductFromCart(RemoveProductRequest removeProductRequest) {
		Long productItemId = removeProductRequest.getProductItemId();
		Long cartId = removeProductRequest.getCartId();
		cartItemRepository.deleteByIdProductItemIdAndIdCartId(productItemId, cartId);
		
		double finalPrice = updateCart(cartId);
		FinalPriceResponse response = new FinalPriceResponse(finalPrice);
		return response;
	}

	@Override
	public FinalPriceResponse checkItem(CheckItemRequest info) {
		Long productItemId = info.getProductItemId();
		Long cartId = info.getCartId();

		CartItem cartItem = cartItemRepository.findByIdProductItemIdAndIdCartId(productItemId, cartId);
		double value = cartItem.isCheck() ? -1d : 1d;

		Cart cart = cartRepository.findById(cartId).get();
		double oldTotalPrice = cart.getTotalPrice();
		double newTotalPrice = oldTotalPrice + cartItem.getTotalPrice() * value;
		cart.setTotalPrice(newTotalPrice);
		cartRepository.save(cart);
		
		cartItem.setCheck(!cartItem.isCheck());
		cartItemRepository.save(cartItem);
		
		double finalPrice = updateCart(cartId);
		FinalPriceResponse response = new FinalPriceResponse(finalPrice);
		return response;
	}

	@Override
	public ChangeQuantityResponse changeQuantity(CartItemInfoRequest info) {
		Long productItemId = info.getProductItemId();
		Long cartId = info.getCartId();
		CartItem cartItem = cartItemRepository.findByIdProductItemIdAndIdCartId(productItemId, cartId);
		int currentQuantity = cartItem.getQuantity();
		
		int newQuantity = currentQuantity + info.getQuantity();
		double productPrice = cartItem.getProductItem().getPrice();

		cartItem.setQuantity(newQuantity);
		cartItem.setTotalPrice(newQuantity * productPrice);
		cartItemRepository.save(cartItem);

		double finalPrice = updateCart(info.getCartId());
		int quantity = cartItem.getQuantity();
		double totalPrice = cartItem.getTotalPrice();

		ChangeQuantityResponse response = new ChangeQuantityResponse(quantity, totalPrice, finalPrice);
		return response;
	}

	@Override
	public FinalPriceResponse checkAllItem(Long cartId) {
		List<CartItem> cartItems = cartItemRepository.findAllItemInCart(cartId);

		boolean allCheck = verifyCartItems(cartItems);		
		
		for (CartItem item : cartItems) {
			if (allCheck == true) {
				item.setCheck(false);
				cartItemRepository.save(item);
			}else {
				item.setCheck(true);
				cartItemRepository.save(item);
			}
		}

		double finalPrice = updateCart(cartId);

		FinalPriceResponse response = new FinalPriceResponse(finalPrice);
		return response;
	}


	@Override
	public void removeAllCheckedItem(Long cartId) {
		cartItemRepository.deleteAllCheckedItem(cartId);
	}

	//bug
	@Override
	public FinalPriceResponse checkAllItemInShop(ShopCheckRequest info) {
		Long cartId = info.getCartId();
		String shopName = info.getShopName();

		Long shopId = shopRepository.findByNameDTO(shopName).getId();
		List<IProductId> productIdList = productRepository.findAllByShopId(shopId);

		List<ICartItemList> cartItems = new ArrayList<>();

		for (int i = 0; i < productIdList.size(); i++) {
			Long productId = productIdList.get(i).getId();
			ICartItemList item = cartItemRepository.findByProductItemId(productId);
			if(item != null) {
				cartItems.add(item);
			}	
		}

		boolean shopCheck = verifyIfContainFalse(cartItems);
		
	
		for (ICartItemList iCartItem : cartItems) {
			Long productItemId = iCartItem.getProductItemId();
			CartItem item = cartItemRepository.findByIdProductItemIdAndIdCartId(productItemId, cartId);
			if (shopCheck == true) {
				item.setCheck(false);
				cartItemRepository.save(item);
			} else {
				item.setCheck(true);
				cartItemRepository.save(item);
			}
		}

		double finalPrice = updateCart(cartId);
		
		FinalPriceResponse response = new FinalPriceResponse(finalPrice);
		
		return response;
	}

	public double updateCart(Long cartId) {
		List<ICartItemList> items = cartItemRepository.findAllCheckedItemInCartDTO(cartId);
		double sum = 0;
		for (int i = 0; i < items.size(); i++) {
			sum += items.get(i).getTotalPrice();
		}
		Cart cart = cartRepository.findById(cartId).get();
		cart.setTotalPrice(sum);
		cartRepository.save(cart);
		return sum;
	}
	
	public boolean verifyIfContainFalse(List<ICartItemList> items) {
		for(ICartItemList item : items) {
				if(!item.isCheck()) {
					return false;
			}	
		}
		return true;
	}
	
	public boolean verifyCartItems(List<CartItem> items) {
		for(CartItem item : items) {
				if(!item.isCheck()) {
					return false;
			}	
		}
		return true;
	}
}
