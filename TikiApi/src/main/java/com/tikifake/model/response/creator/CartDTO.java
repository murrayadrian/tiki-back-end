package com.tikifake.model.response.creator;

import java.util.List;

import com.tikifake.model.response.detail.IUserDetail;
import com.tikifake.model.response.list.ICart;
import com.tikifake.model.response.list.ICartItemList;

public class CartDTO {
	
	private ICart cartInfo;
	
	private IUserDetail userInfo;
	
	private List<ICartItemList> cartItems;
	

	public ICart getCartInfo() {
		return cartInfo;
	}

	public void setCartInfo(ICart cartInfo) {
		this.cartInfo = cartInfo;
	}


	public IUserDetail getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(IUserDetail userInfo) {
		this.userInfo = userInfo;
	}

	public List<ICartItemList> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<ICartItemList> cartItems) {
		this.cartItems = cartItems;
	}
	
}
