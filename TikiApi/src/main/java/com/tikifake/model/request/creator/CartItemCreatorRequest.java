package com.tikifake.model.request.creator;

import com.tikifake.entity.Cart;
import com.tikifake.entity.CartItem;
import com.tikifake.entity.Product;

public class CartItemCreatorRequest {

	private Long cartId;
	
	private Long productId;

	private int orderQuantity;

	
	
	public CartItem convertToEntity(Product product, Cart cart) {
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setQuantity(orderQuantity);
		cartItem.setTotalPrice(orderQuantity * product.getPrice());
		cartItem.setTotalWeight(orderQuantity * product.getWeight());
		cartItem.setCheck(false);
		return cartItem;
	}
	
	public CartItem updateExistedCartItem(CartItem cartItem, int orderQuantity) {
		int updateQuantity = cartItem.getQuantity() + orderQuantity;
		cartItem.setQuantity(updateQuantity);
		cartItem.setTotalPrice(updateQuantity * cartItem.getProduct().getPrice());
		cartItem.setTotalWeight(updateQuantity * cartItem.getProduct().getWeight());
		return cartItem;
	}
	
	public Long getProductId() {
		return productId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}
	
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity =  orderQuantity;
	}

	public Long getCartId() {
		return cartId;
	}
	
	
	
}
