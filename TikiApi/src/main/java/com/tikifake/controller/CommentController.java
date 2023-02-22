package com.tikifake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tikifake.model.request.creator.CommentCreatorRequest;
import com.tikifake.model.response.list.ICommentList;
import com.tikifake.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@GetMapping("/getCommentByProduct/{productId}")
	public ResponseEntity<Object> getCommentByProduct(@PathVariable(value = "productId") Long productId) {
		List<ICommentList> comments = commentService.getCommentByProduct(productId);
		return ResponseEntity.ok().body(comments);
	}
	
	@PostMapping("/postCommentByProduct/{productId}")
	public ResponseEntity<Object> getCommentByProduct(@RequestBody CommentCreatorRequest commentCreator) {
		List<ICommentList> comments = commentService.postComment(commentCreator);
		return ResponseEntity.ok().body(comments);
	}
}
