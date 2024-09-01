package com.devesh.blogApplication.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.devesh.blogApplication.dto.PostDto;
import com.devesh.blogApplication.repo.PostRepo;
import com.devesh.blogApplication.service.PostService;

public class PostServiceImp implements PostService {
	@Autowired
	PostRepo repo;

	@Override
	public PostDto createPost(PostDto postDto) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto getPostById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
