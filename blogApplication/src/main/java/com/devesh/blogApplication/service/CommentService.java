package com.devesh.blogApplication.service;

import java.util.List;

import com.devesh.blogApplication.dto.CommentDto;

public interface CommentService {
	CommentDto createComment(CommentDto commentDto,Integer postId,Integer userId);
	CommentDto updateComment(CommentDto commentDto , Integer commentId);
	void deleteComment(Integer commentId);
	CommentDto getCommentById(Integer id);
	List<CommentDto> getAllComment();


}
