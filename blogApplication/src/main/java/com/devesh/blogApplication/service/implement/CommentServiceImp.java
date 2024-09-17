package com.devesh.blogApplication.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devesh.blogApplication.dto.CommentDto;
import com.devesh.blogApplication.entity.Comment;
import com.devesh.blogApplication.entity.Post;
import com.devesh.blogApplication.entity.User;
import com.devesh.blogApplication.exception.ResourceNotFoundException;
import com.devesh.blogApplication.repo.CommentRepo;
import com.devesh.blogApplication.repo.PostRepo;
import com.devesh.blogApplication.repo.UserRepo;
import com.devesh.blogApplication.service.CommentService;

@Service
public class CommentServiceImp implements CommentService {
	@Autowired
	CommentRepo repo;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	PostRepo postRepo;
	@Autowired
	UserRepo userRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto,Integer postId,Integer userId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","Post Id",postId));
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User Id",userId));
	Comment comment = 	this.modelMapper.map(commentDto, Comment.class);
	comment.setPost(post);
	comment.setUser(user);
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
