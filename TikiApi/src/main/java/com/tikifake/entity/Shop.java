package com.tikifake.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_shop")
	@SequenceGenerator(name = "seq_shop", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@Column
	private String name;
	
	
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

}
