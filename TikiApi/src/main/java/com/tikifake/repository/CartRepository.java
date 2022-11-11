package com.tikifake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	
	@Query("select c from Cart c where c.user.id = ?1")
	public Cart findByUserId(Long id);
}
