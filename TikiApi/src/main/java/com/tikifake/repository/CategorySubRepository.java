package com.tikifake.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.CategorySub;
import com.tikifake.model.response.detail.ICategorySubDetail;
import com.tikifake.model.response.list.ICategorySubList;

public interface CategorySubRepository extends JpaRepository<CategorySub, Long>{
	@Query("select t from CategorySub t")
	public List<ICategorySubList> findAllDTO(Pageable pageable);

	@Query("select t from CategorySub t where t.id= ?1")
	public ICategorySubDetail findByIdDTO(Long id);
	
	@Query("select c from CategorySub c WHERE c.category.id = ?1")
	public List<ICategorySubDetail> findByCategoryId(Long id);
}
