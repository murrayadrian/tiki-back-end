package com.tikifake.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.Comment;
import com.tikifake.model.response.detail.ICommentDetail;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	@Query("select c from Comment c")
	public List<ICommentDetail> findAllDTO();

	@Query("select c from Comment c where c.id= ?1")
	public ICommentDetail findByIdDTO(Long id);
}
