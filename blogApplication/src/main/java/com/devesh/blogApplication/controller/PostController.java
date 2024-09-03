package com.devesh.blogApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.blogApplication.dto.PostDto;
import com.devesh.blogApplication.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
	@Autowired
	PostService service;
	
	@PostMapping("/")
	public ResponseEntity<PostDto> createPost(PostDto postDto){
	PostDto p = 	this.service.createPost(postDto);
	return new ResponseEntity<PostDto>(p,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(PostDto postDto, Integer id){
		
		PostDto post = this.service.updatePost(postDto, id);
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDto>getPostById(@PathVariable Integer id){
		PostDto p = this.service.getPostById(id);
		return new  ResponseEntity<PostDto>(p, HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<PostDto>>getAllPost(){
	List<PostDto>list = 	this.service.getAllPost();
	return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);
	}
	@DeleteMapping("/")
	public String deletePost(@PathVariable Integer id) {
		this.service.deletePost(id);
		return "Post deleted Succesfully";
	}

}
