package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.CommentCreatorRequest;
import com.tikifake.model.response.list.ICommentList;

public interface CommentService {

	public List<ICommentList> getCommentByProduct(Long productId);

	public List<ICommentList> postComment(CommentCreatorRequest commentCreator);
}
