package com.tikifake.model;

import java.util.Set;

import com.tikifake.entity.Product;

public interface IShop {

	public Long getId();
	
	public String getName();
	
	public Set<Product> getProduct();
}
