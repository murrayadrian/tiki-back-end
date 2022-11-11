package com.tikifake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.Comment;
import com.tikifake.model.response.list.ICommentList;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	@Query("select c from Comment c where c.product.id = :id")
	public List<ICommentList> findAllByProduct(Long id);
	
	@Query("select c.user.id from Comment c where c.user.id = :id")
	public ICommentList findCommentByUser(Long id);
}