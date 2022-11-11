package com.tikifake.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.Category;
import com.tikifake.model.response.detail.ICategoryDetail;
import com.tikifake.model.response.list.ICategoryList;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query("select t from Category t")
	public List<ICategoryList> findAllCategory(Pageable pageable);

	@Query("select t from Category t where t.id= ?1")
	public ICategoryDetail findByIdDTO(Long id);
}
