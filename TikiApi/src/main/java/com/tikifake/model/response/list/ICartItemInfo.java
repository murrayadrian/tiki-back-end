package com.tikifake.model.response.list;

import java.util.List;

public class ICartItemInfo {
	
	private String shopName;
	
	private List<ICartItemList> cartItemList;

	
	
	
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<ICartItemList> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<ICartItemList> cartItemList) {
		this.cartItemList = cartItemList;
	}

	@Override
	public String toString() {
		return "ICartItemInfo [shopName=" + shopName + "]";
	}
	
	
}
