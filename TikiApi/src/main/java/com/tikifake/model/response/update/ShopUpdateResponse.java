package com.tikifake.model.response.update;

import com.tikifake.entity.Shop;

public class ShopUpdateResponse {

	public Long id;
	
	public String name;

	public ShopUpdateResponse convertEntityToModel(Shop shop) {
		this.id = shop.getId();
		this.name = shop.getName();
		return this;
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
