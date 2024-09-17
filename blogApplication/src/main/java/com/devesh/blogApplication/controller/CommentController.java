package com.devesh.blogApplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.blogApplication.dto.ApiResponce;
import com.devesh.blogApplication.dto.CommentDto;
import com.devesh.blogApplication.service.implement.CommentServiceImp;


@RestController
@RequestMapping("/api/")
public class CommentController {
	@Autowired
	CommentServiceImp service;

	@PostMapping("/post/{postId}/user/{userId}/comments")
	public ResponseEntity<CommentDto>createComment(@Valid @RequestBody CommentDto commentDto, @PathVariable Integer postId,Integer userId){
		CommentDto co =service.createComment(commentDto,postId,userId);
		return new ResponseEntity<>(co, HttpStatus.CREATED);
	}
	@PutMapping("/comments/{commentId}")
	public ResponseEntity<CommentDto>updateComment( @Valid @RequestBody  CommentDto commentDto, @PathVariable Integer commentId){
		CommentDto comment = this.service.updateComment(commentDto, commentId);
		return new ResponseEntity<>(comment,HttpStatus.OK);

	}

	@GetMapping("/comments/{commentId}")
	public ResponseEntity<CommentDto>getCommentById(@PathVariable Integer commentId){
		 CommentDto comment =  this.service.getCommentById(commentId);
		 return new ResponseEntity<>(comment, HttpStatus.OK);
	}
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponce> deleteComment(@PathVariable Integer commentId){
		this.service.deleteComment(commentId);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Comment deleted Succesfully",true),HttpStatus.OK);
	}
	@GetMapping("/comments")
	public ResponseEntity<List<CommentDto>> getAllComment(){
	List<CommentDto>list=	this.service.getAllComment();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}


}
