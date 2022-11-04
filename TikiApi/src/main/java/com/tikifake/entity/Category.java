package com.tikifake.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6867992745893110729L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
	@SequenceGenerator(name = "seq_category", allocationSize = 1, initialValue = 1)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
//	private Set<Product> products;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Set<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Set<Product> products) {
//		this.products = products;
//	}
}