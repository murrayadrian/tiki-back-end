package com.tikifake.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.Category;
import com.tikifake.model.ICategory;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query("select t from Category t")
	public List<ICategory> findAllDTO();

	@Query("select t from Category t where t.id= ?1")
	public ICategory findByIdDTO(Long id);
}
