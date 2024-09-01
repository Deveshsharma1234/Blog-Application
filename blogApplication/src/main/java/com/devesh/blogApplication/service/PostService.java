package com.devesh.blogApplication.service;

import java.util.List;

import com.devesh.blogApplication.dto.PostDto;

public interface PostService { 
	
	PostDto createPost(PostDto postDto);
	PostDto updatePost(PostDto postDto, Integer id);
	PostDto getPostById(Integer id);
	List<PostDto> getAllPost();
	void deletePost(Integer id);
	
	

}
