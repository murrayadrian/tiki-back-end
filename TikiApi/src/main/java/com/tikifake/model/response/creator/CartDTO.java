package com.tikifake.model.response.creator;

import java.util.List;

import com.tikifake.model.response.detail.IUserDetail;
import com.tikifake.model.response.list.ICart;
import com.tikifake.model.response.list.ICartItemInfo;

public class CartDTO {
	
	private int items;
	
	private ICart cartInfo;
	
	private IUserDetail userInfo;
	
	private List<ICartItemInfo> cartItemInfoList;
	

	
	
	

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

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

	public List<ICartItemInfo> getCartItemInfoList() {
		return cartItemInfoList;
	}

	public void setCartItemInfoList(List<ICartItemInfo> cartItemInfoList) {
		this.cartItemInfoList = cartItemInfoList;
	}

	
}
