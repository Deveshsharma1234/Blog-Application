package com.devesh.blogApplication.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.multipart.MultipartFile;

import com.devesh.blogApplication.dto.ApiResponce;
import com.devesh.blogApplication.dto.PostDto;
import com.devesh.blogApplication.dto.PostResponce;
import com.devesh.blogApplication.service.FileService;
import com.devesh.blogApplication.service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	@Autowired
	PostService service;
	@Autowired
	 FileService fs;
	@Value("${project.image}")
	 String path;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
	    @RequestBody PostDto postDto,
	    @PathVariable Integer userId,
	    @PathVariable Integer categoryId) {

	    PostDto p = this.service.createPost(postDto, userId, categoryId);
	    return new ResponseEntity<>(p, HttpStatus.CREATED);
	}



	@PutMapping("/post/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable  Integer id){

		PostDto post = this.service.updatePost(postDto, id);
		return new ResponseEntity<>(post,HttpStatus.OK);
	}

	@GetMapping("/post/{id}")
	public ResponseEntity<PostDto>getPostById(@PathVariable Integer id){
		PostDto p = this.service.getPostById(id);
		return new  ResponseEntity<>(p, HttpStatus.OK);
	}
	@GetMapping("/post")
	public ResponseEntity<PostResponce>getAllPost(
		@RequestParam(value = "pageNumber", defaultValue = "0",required = false)	Integer pageNumber,
		@RequestParam(value = "pageSize",defaultValue = "10",required = false)	Integer pageSize,
		@RequestParam(value = "sortBy", defaultValue = "postId",required = false)String sortBy){
	PostResponce responce = 	this.service.getAllPost(pageNumber,pageSize,sortBy);
	return new ResponseEntity<>(responce,HttpStatus.OK);
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
		 return new ResponseEntity<>(postList, HttpStatus.OK);

	}
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(Integer userId){
	  List<PostDto>list =	this.service.getPostByUser(userId);
	  return new ResponseEntity<>(list,HttpStatus.OK);
	}

	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>>searchPost(@PathVariable("keyword") String keyword){
		   List<PostDto>list = this.service.searchPosts(keyword);
		   return new ResponseEntity<>(list,HttpStatus.OK);

	}
	///////////////////////////////////Post image upload////

	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto>uploadImage(@PathVariable Integer postId,
			@RequestParam("image") MultipartFile image
			) throws IOException{
		PostDto postDto	=  this.service.getPostById(postId);
		 String fileName = this.fs.uploadImage(path, image);
	postDto.setImageName(fileName);
	 PostDto updatePost = this.service.updatePost(postDto, postId);
	 System.out.println("Inside the PostController --> image upladed");
	 return new ResponseEntity<>(updatePost,HttpStatus.OK);


	}



















}
