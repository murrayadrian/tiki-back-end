package com.tikifake.model.request.creator;

import com.tikifake.entity.Shop;

public class ShopCreator {
	
	private String name;

	public Shop convertModelToEntity() {
		Shop shop = new Shop();
		shop.setName(this.name);
		return shop;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
