package com.tikifake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tikifake.entity.Product;
import com.tikifake.entity.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long>{
	
	public ProductItem findTop1ByProductOrderByPrice(Product product);
}
