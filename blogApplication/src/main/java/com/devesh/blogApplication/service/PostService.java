package com.devesh.blogApplication.service;

import java.util.List;

import com.devesh.blogApplication.dto.PostDto;

public interface PostService { 
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	PostDto updatePost(PostDto postDto, Integer id);
	PostDto getPostById(Integer id);
	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
	void deletePost(Integer id);
	
	List<PostDto>getPostByUser(Integer userId);
	List<PostDto>getPostByCategory(Integer categoryId);
	
	List<PostDto> searchPosts(String keyword);
	
	
	

}
