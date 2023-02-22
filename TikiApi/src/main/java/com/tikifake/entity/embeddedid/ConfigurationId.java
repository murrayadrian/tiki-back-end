package com.tikifake.entity.embeddedid;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ConfigurationId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long itemId;
	
	private Long valueId;
	

	public ConfigurationId() {
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getValueId() {
		return valueId;
	}

	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, valueId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfigurationId other = (ConfigurationId) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(valueId, other.valueId);
	}
}
