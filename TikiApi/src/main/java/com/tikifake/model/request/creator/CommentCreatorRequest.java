package com.tikifake.model.request.creator;

import com.tikifake.entity.Comment;
import com.tikifake.entity.Product;
import com.tikifake.entity.User;

public class CommentCreatorRequest {
	
	private String comment;
	
	private Long userId;
	
	private Long productId;
	
	public Comment convertToEntity(User user, Product product) {
		Comment comment = new Comment();
		comment.setProduct(product);
		comment.setUser(user);
		comment.setComment(this.comment);
		return comment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
