package com.tikifake.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.Product;
import com.tikifake.model.response.detail.IProductDetail;
import com.tikifake.model.response.list.IProductId;
import com.tikifake.model.response.list.IProductList;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select t from Product t")
	public List<IProductList> findAllDTO(Pageable pageable);

	@Query("select t from Product t where t.id= ?1")
	public IProductDetail findByIdDTO(Long id);
	
	@Query("select p from Product p JOIN FETCH p.categorySub WHERE p.categorySub.id = ?1")
	public List<IProductDetail> findByCategorySubId(Long id);
	
	@Query("select p from Product p where p.shop.id = ?1")
	public List<IProductId> findAllProductInShop(Long shopId);
	
}
