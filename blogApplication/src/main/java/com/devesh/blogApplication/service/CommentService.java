package com.devesh.blogApplication.service;

import com.devesh.blogApplication.dto.CommentDto;

public interface CommentService {
	CommentDto createComment(CommentDto commentDto);
	CommentDto updateComment(CommentDto commentDto , Integer commentId);
	void deleteComment(Integer commentId);
	

}
