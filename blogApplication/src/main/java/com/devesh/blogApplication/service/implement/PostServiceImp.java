package com.devesh.blogApplication.service.implement;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.blogApplication.dto.ApiResponce;
import com.devesh.blogApplication.dto.CategoryDto;
import com.devesh.blogApplication.dto.PostDto;
import com.devesh.blogApplication.dto.UserDto;
import com.devesh.blogApplication.entity.Category;
import com.devesh.blogApplication.entity.Post;
import com.devesh.blogApplication.entity.User;
import com.devesh.blogApplication.exception.ResourceNotFoundException;
import com.devesh.blogApplication.repo.CategoryRepo;
import com.devesh.blogApplication.repo.PostRepo;
import com.devesh.blogApplication.repo.UserRepo;
import com.devesh.blogApplication.service.PostService;

@RestController
public class PostServiceImp implements PostService {
	@Autowired
	PostRepo repo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CategoryRepo categoryRepo;

	// Create
	@Override
	public PostDto createPost(PostDto postDto, Integer userID, Integer categoryId) {

		User user = this.userRepo.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userID));
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setDate(new Date());
		post.setCategory(category);
		;
		post.setUser(user);
		this.repo.save(post);
		return this.modelMapper.map(post, PostDto.class);

	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer id) {
		// TODO Auto-generated method stub
		Post post = this.repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		post.setContent(postDto.getContent());
		post.setTitle(postDto.getTitle());
		post.setImageName(postDto.getImageName());
		this.repo.save(post);
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto getPostById(Integer id) {
		Post post = this.repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		return this.modelMapper.map(post, PostDto.class);

	}

	@Override
	public List<PostDto> getAllPost(Integer pageNumber, Integer pageSize) {
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<Post> pagePost = this.repo.findAll(p);
		List<Post>allPosts = pagePost.getContent();
		
		return allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

	}

	@Override
	public void deletePost(Integer id) {
		// TODO Auto-generated method stub
		Post post = this.repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		this.repo.delete(post);
		
		System.out.println("Post Deleted Successfully!!");
		
	}
	// -----------------------------------------

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		List<Post> postList = this.repo.findByUser(user);
		return postList.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category", categoryId));
		List<Post> postList = this.repo.findByCategory(category);
		return postList.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
