package com.devesh.blogApplication.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devesh.blogApplication.dto.CommentDto;
import com.devesh.blogApplication.entity.Comment;
import com.devesh.blogApplication.exception.ResourceNotFoundException;
import com.devesh.blogApplication.repo.CommentRepo;
import com.devesh.blogApplication.service.CommentService;

@Service
public class CommentServiceImp implements CommentService {
	@Autowired
	CommentRepo repo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto) {
	Comment comment = 	this.modelMapper.map(commentDto, Comment.class);
	 repo.save(comment);

		return this.modelMapper.map(comment, CommentDto.class);
	}

	@Override
	public CommentDto updateComment(CommentDto commentDto, Integer commentId) {
		// TODO Auto-generated method stub
		Comment comment = this.repo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment","Id", commentId));
		comment.setComment(commentDto.getComment());
		repo.save(comment);
		return this.modelMapper.map(comment, CommentDto.class) ;
	}

	@Override
	public void deleteComment(Integer commentId) {
	// TODO Auto-generated method stub
	   Comment comment   =	this.repo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment","Id",commentId));
	   repo.delete(comment);
	   System.out.println("Comment Deleted Succussfully!!");
	}

	@Override
	public CommentDto getCommentById(Integer id) {
		// TODO Auto-generated method stub
		Comment comm = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Comment", "id", id));
		return this.modelMapper.map(comm, CommentDto.class);
	}

	@Override
	public List<CommentDto> getAllComment() {
		// TODO Auto-generated method stub
		List<Comment>comments    =this.repo.findAll();
	 List<CommentDto> list = comments.stream().map((comment)-> this.modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
		return list;
	}

}
