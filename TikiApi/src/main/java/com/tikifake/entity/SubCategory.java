package com.tikifake.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Category_sub")
public class CategorySub implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3562300339352297142L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category_sub")
	@SequenceGenerator(name = "seq_category_sub", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Long getCategoryId() {
		return category.getId();
	}
	
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
