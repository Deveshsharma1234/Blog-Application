package com.devesh.blogApplication.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.blogApplication.dto.PostDto;
import com.devesh.blogApplication.entity.Post;
import com.devesh.blogApplication.exception.ResourceNotFoundException;
import com.devesh.blogApplication.repo.PostRepo;
import com.devesh.blogApplication.service.PostService;

@RestController
public class PostServiceImp implements PostService {
	@Autowired
	PostRepo repo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto createPost(PostDto postDto) {
		Post post = this.modelMapper.map(postDto, Post.class);
		this.repo.save(post);
		return this.modelMapper.map(post, PostDto.class);
		
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer id) {
		// TODO Auto-generated method stub
		 Post post = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
		 post.setContent(postDto.getContent());
		 post.setTitle(postDto.getTitle());
		 this.repo.save(post);
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto getPostById(Integer id) {
			Post post = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id));
			return this.modelMapper.map(post, PostDto.class);
		
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> list = this.repo.findAll();
	return	list.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public void deletePost(Integer id) {
		// TODO Auto-generated method stub
		Post post = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id));
		this.repo.delete(post);
		System.out.println("Post Deleted Successfully!!");
	}

}
