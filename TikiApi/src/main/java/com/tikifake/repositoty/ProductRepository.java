package com.tikifake.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.Product;
import com.tikifake.model.IProduct;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select t from Product t")
	public List<IProduct> findAllDTO();

	@Query("select t from Product t where t.id= ?1")
	public IProduct findByIdDTO(Long id);
}
