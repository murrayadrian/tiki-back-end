package com.tikifake.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.Category;
import com.tikifake.model.response.detail.ICategoryDetail;
import com.tikifake.model.response.list.ICategoryList;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query("select t from Category t")
	public List<ICategoryList> findAllCategory();

	@Query("select t from Category t where t.id= ?1")
	public ICategoryDetail findByIdDTO(Long id);
	
	public Category findByUrlKey(String urlKey);
	
	@Query("select c from Category c where c.level = ?1")
	public List<ICategoryList> getLevel1Category(int level);
	
	@Query("select c from Category c")
	public List<ICategoryList> getAll();
	
	public boolean existsByName(String name);
	
	public Category findByName(String name);
	
	@Query("select c from Category c where c.parentCategory.id = ?1")
	public List<ICategoryList> findByParentId(Long parentId);
	
	@Query("select c from Category c where c.parentCategory.id IS NULL")
	public List<ICategoryList> findByNullParentId();
}
