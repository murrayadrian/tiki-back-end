package com.tikifake.entity.embeddedid;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CartItemId implements Serializable {

	private static final long serialVersionUID = 1L;
	public Long cartId;
	public Long productItemId;
	
	public CartItemId() {
		
	}
	public CartItemId(Long cartId, Long productItemId) {
		this.cartId = cartId;
		this.productItemId = productItemId;
	}

	public Long getCartId() {
		return cartId;
	}

	public Long getProductItemId() {
		return productItemId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public void setProductItemId(Long productItemId) {
		this.productItemId = productItemId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cartId, productItemId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemId other = (CartItemId) obj;
		return Objects.equals(cartId, other.cartId) && Objects.equals(productItemId, other.productItemId);
	}

}
