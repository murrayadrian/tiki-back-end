package com.tikifake.entity;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "Products")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3782633498469009466L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
	@SequenceGenerator(name = "seq_product", allocationSize = 1, initialValue = 1)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description", columnDefinition = "text")
	private String description;

	@Column(name = "price")
	private double price;

	@Column(name = "image")
	private String image;

	@Column(name = "brand")
	private String brand;
	
	@Column(name = "made_by")
	private String madeBy;

	@Column(name = "create_date")
	private LocalDate createDate;
	
	@ManyToOne
	@JoinColumn(name = "category_sub_id")
	private CategorySub categorySub;

	public Long getCategorySubId() {
		return categorySub.getId();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public CategorySub getCategorySub() {
		return categorySub;
	}

	public void setCategorySub(CategorySub categorySub) {
		this.categorySub = categorySub;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

}
