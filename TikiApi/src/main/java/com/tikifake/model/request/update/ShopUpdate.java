package com.tikifake.model.request.update;

import com.tikifake.entity.Shop;

public class ShopUpdate {
	
	public Long id;

	public String name;

	public Shop convertModelToEntity() {
		Shop shop = new Shop();
		shop.setId(id);
		shop.setName(name);
		return shop;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
