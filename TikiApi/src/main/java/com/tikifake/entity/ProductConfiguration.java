package com.tikifake.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.tikifake.entity.embeddedid.ConfigurationId;

@Entity
public class ProductConfiguration {
	@EmbeddedId
	public ConfigurationId productConfigId = new ConfigurationId();
	
	@MapsId("itemId")
	@ManyToOne
	private ProductItem productItem;
	
	@MapsId("valueId")
	@ManyToOne
	private VariationValue value ;
	
	public ConfigurationId getProductConfigId() {
		return productConfigId;
	}

	public void setProductConfigId(ConfigurationId productConfigId) {
		this.productConfigId = productConfigId;
	}

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	public VariationValue getValue() {
		return value;
	}

	public void setValue(VariationValue value) {
		this.value = value;
	}
}
