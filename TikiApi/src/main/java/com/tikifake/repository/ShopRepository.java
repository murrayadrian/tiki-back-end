package com.tikifake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tikifake.entity.Shop;
import com.tikifake.model.response.detail.IShopDetail;
import com.tikifake.model.response.list.IShopList;

public interface ShopRepository extends JpaRepository<Shop, Long> {
	@Query("select s from Shop s")
	public List<IShopList> findAllDTO();
	
	@Query("select s from Shop s where s.id= ?1")
	public IShopDetail findByIdDTO(Long id);

	Boolean existsByName(String name);
	
	@Query("select count(s.name) > 0 from Shop s where s.id != :id and s.name = :nameUpdate")
	public boolean isExistNameUpdate(@Param("id") Long id, @Param("nameUpdate") String nameUpdate);
}
