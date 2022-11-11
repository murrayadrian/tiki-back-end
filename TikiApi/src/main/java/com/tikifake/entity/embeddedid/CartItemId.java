package com.tikifake.entity.embeddedid;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CartItemId implements Serializable {

	private static final long serialVersionUID = 1L;
	public Long cartId;
	public Long productId;
	
	public CartItemId() {
		
	}
	public CartItemId(Long cartId, Long productId) {
		super();
		this.cartId = cartId;
		this.productId = productId;
	}

	public Long getCartId() {
		return cartId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cartId, productId);
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
		return Objects.equals(cartId, other.cartId) && Objects.equals(productId, other.productId);
	}

}
