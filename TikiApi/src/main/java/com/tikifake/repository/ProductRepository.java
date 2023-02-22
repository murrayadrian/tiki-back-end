package com.tikifake.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.Product;
import com.tikifake.model.response.detail.IProductDetail;
import com.tikifake.model.response.list.IProductId;
import com.tikifake.model.response.list.IProductList;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select t from Product t")
	public List<IProductList> findAllDTO();

	@Query("select t from Product t where t.id= ?1")
	public IProductDetail findByIdDTO(Long id);
	
	@Query("select p from Product p JOIN FETCH p.category WHERE p.category.id = ?1")
	public List<IProductDetail> findAllByCategoryId(Long id);
	
	@Query("select p from Product p where p.shop.id = ?1")
	public List<IProductId> findAllByShopId(Long shopId);
	
	@Query("select p from Product p")
	public Page<Product> findAll(PageRequest request);
}
