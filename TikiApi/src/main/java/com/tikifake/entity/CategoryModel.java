package com.tikifake.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Category_model")
public class CategoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
	@SequenceGenerator(name = "seq_category", allocationSize = 5)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_brand_id")
	private CategoryBrand categoryBrand;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryBrand getCategoryBrand() {
		return categoryBrand;
	}

	public void setCategoryBrand(CategoryBrand categoryBrand) {
		this.categoryBrand = categoryBrand;
	}
}
