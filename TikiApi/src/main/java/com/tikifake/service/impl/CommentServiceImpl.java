package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Comment;
import com.tikifake.entity.Product;
import com.tikifake.entity.User;
import com.tikifake.model.request.creator.CommentCreatorRequest;
import com.tikifake.model.response.exception.BadRequestException;
import com.tikifake.model.response.exception.NotFoundException;
import com.tikifake.model.response.list.ICommentList;
import com.tikifake.repository.CommentRepository;
import com.tikifake.repository.ProductRepository;
import com.tikifake.repository.UserRepository;
import com.tikifake.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<ICommentList> getCommentByProduct(Long id) {
		return commentRepository.findAllByProduct(id);
	}

	@Override
	public List<ICommentList> postComment(CommentCreatorRequest commentCreator) {
		ICommentList userComment = commentRepository.findCommentByUser(commentCreator.getUserId());
		if(userComment != null) {
			throw new BadRequestException("User have already commented");
		}
		Product product = productRepository.findById(commentCreator.getProductId()).get();
		if(product == null) {
			throw new NotFoundException("Product NOT FOUND");
		}
		User user = userRepository.findById(commentCreator.getUserId()).get();
		if(user == null) {
			throw new NotFoundException("User NOT FOUND");
		}
		Comment comment = commentCreator.convertToEntity(user, product);
		commentRepository.save(comment);
		return commentRepository.findAllByProduct(commentCreator.getProductId());
	}

}
