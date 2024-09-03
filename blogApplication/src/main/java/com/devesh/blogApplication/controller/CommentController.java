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

import com.devesh.blogApplication.dto.CommentDto;
import com.devesh.blogApplication.service.implement.CommentServiceImp;


@RestController
@RequestMapping("/api/comment")
public class CommentController {
	@Autowired
	CommentServiceImp service;
	
	@PostMapping("/")
	public ResponseEntity<CommentDto>createComment(@Valid @RequestBody CommentDto commentDto){
		CommentDto co =service.createComment(commentDto);
		return new ResponseEntity<CommentDto>(co, HttpStatus.CREATED);		
	}
	@PutMapping("/{id}")
	public ResponseEntity<CommentDto>updateComment( @Valid @RequestBody  CommentDto commentDto, @PathVariable Integer id){
		CommentDto comment = this.service.updateComment(commentDto, id);
		return new ResponseEntity<CommentDto>(comment,HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CommentDto>getCommentById(@PathVariable Integer id){
		 CommentDto comment =  this.service.getCommentById(id);
		 return new ResponseEntity<CommentDto>(comment, HttpStatus.OK);
	}
	@DeleteMapping("/")
	public String deleteComment(@PathVariable Integer id){
		this.service.deleteComment(id);
		return "Comment Deleted!!";
	}
	@GetMapping("/")
	public ResponseEntity<List<CommentDto>> getAllComment(){
	List<CommentDto>list=	this.service.getAllComment();
		return new ResponseEntity<List<CommentDto>>(list,HttpStatus.OK);
	}
	

}
