package com.devesh.blogApplication.service;

import java.util.List;

import com.devesh.blogApplication.dto.PostDto;
import com.devesh.blogApplication.dto.PostResponce;

public interface PostService {

	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	PostDto updatePost(PostDto postDto, Integer id);
	PostDto getPostById(Integer id);
	PostResponce getAllPost(Integer pageNumber, Integer pageSize,String sortBy);
	void deletePost(Integer id);

	List<PostDto>getPostByUser(Integer userId);
	List<PostDto>getPostByCategory(Integer categoryId);

	List<PostDto> searchPosts(String keyword);




}
