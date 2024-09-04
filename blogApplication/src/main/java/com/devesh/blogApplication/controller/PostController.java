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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.blogApplication.dto.ApiResponce;
import com.devesh.blogApplication.dto.PostDto;
import com.devesh.blogApplication.service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	@Autowired
	PostService service;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
	    @RequestBody PostDto postDto,
	    @PathVariable Integer userId,
	    @PathVariable Integer categoryId) {
	    
	    PostDto p = this.service.createPost(postDto, userId, categoryId);
	    return new ResponseEntity<>(p, HttpStatus.CREATED);
	}


	
	@PutMapping("/post/{id}")
	public ResponseEntity<PostDto> updatePost(PostDto postDto, Integer id){
		
		PostDto post = this.service.updatePost(postDto, id);
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	}
	
	@GetMapping("/post/{id}")
	public ResponseEntity<PostDto>getPostById(@PathVariable Integer id){
		PostDto p = this.service.getPostById(id);
		return new  ResponseEntity<PostDto>(p, HttpStatus.OK);
	}
	@GetMapping("/post")
	public ResponseEntity<List<PostDto>>getAllPost(
		@RequestParam(value = "pageNumber", defaultValue = "0",required = false)	Integer pageNumber, 
		@RequestParam(value = "pageSize",defaultValue = "10",required = false)	Integer pageSize){
	List<PostDto>list = 	this.service.getAllPost(pageNumber,pageSize);	
	return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);
	}
	@DeleteMapping("/post/{id}")
	public ApiResponce deletePost(@PathVariable Integer id) {
		this.service.deletePost(id);
		return new ApiResponce("Post Deleted Successfully",true);
	}
	//------------------------------------------------
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>>getPostByCategory(Integer categoryId){
		 List<PostDto> postList = this.service.getPostByCategory(categoryId);
		 return new ResponseEntity<List<PostDto>>(postList, HttpStatus.OK);

	}
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(Integer userId){
	  List<PostDto>list =	this.service.getPostByUser(userId);
	  return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);
	}

}
