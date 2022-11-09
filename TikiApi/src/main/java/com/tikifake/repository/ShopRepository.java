package com.tikifake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.Shop;
import com.tikifake.model.response.detail.IShopDetail;

public interface ShopRepository extends JpaRepository<Shop, Long>{
	@Query("select s from Shop s")
	public List<IShopDetail> findAllDTO();

	@Query("select s from Shop s where s.id= ?1")
	public IShopDetail findByIdDTO(Long id);
}
