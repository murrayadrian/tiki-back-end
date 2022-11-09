package com.tikifake.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.Product;
import com.tikifake.model.response.detail.IProductDetail;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select t from Product t")
	public List<IProductDetail> findAllDTO();

	@Query("select t from Product t where t.id= ?1")
	public IProductDetail findByIdDTO(Long id);
	
	@Query("select p from Product p JOIN FETCH p.categorySub WHERE p.categorySub.id = ?1")
	public List<IProductDetail> findByCategorySubId(Long id);
	
}
