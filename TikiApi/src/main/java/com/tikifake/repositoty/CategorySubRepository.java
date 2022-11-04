package com.tikifake.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.CategorySub;
import com.tikifake.model.ICategorySub;

public interface CategorySubRepository extends JpaRepository<CategorySub, Long>{
	@Query("select t from CategorySub t")
	public List<ICategorySub> findAllDTO();

	@Query("select t from CategorySub t where t.id= ?1")
	public ICategorySub findByIdDTO(Long id);
}
