package com.tikifake.entity.embeddedid;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class OrderItemId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Long orderId;
	
	public Long productId;

	public OrderItemId() {
		
	}

	public Long getOrderId() {
		return orderId;
	}

	public Long getProductId() {
		return productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemId other = (OrderItemId) obj;
		return Objects.equals(orderId, other.orderId) && Objects.equals(productId, other.productId);
	}
	
}
