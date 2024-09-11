package com.devesh.blogApplication.service.implement;



import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devesh.blogApplication.dto.PostDto;
import com.devesh.blogApplication.dto.PostResponce;
import com.devesh.blogApplication.entity.Category;
import com.devesh.blogApplication.entity.Post;
import com.devesh.blogApplication.entity.User;
import com.devesh.blogApplication.exception.ResourceNotFoundException;
import com.devesh.blogApplication.repo.CategoryRepo;
import com.devesh.blogApplication.repo.PostRepo;
import com.devesh.blogApplication.repo.UserRepo;
import com.devesh.blogApplication.service.PostService;



@Service
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
	public PostResponce getAllPost(Integer pageNumber, Integer pageSize,String sortBy) {

		Pageable p = PageRequest.of(pageNumber, pageSize,Sort.by(sortBy));

		Page<Post> pagePost = this.repo.findAll(p);
		List<Post>allPosts = pagePost.getContent();
		PostResponce postResponce = new PostResponce();
		List<PostDto>postDto =  allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		postResponce.setContents(postDto);
			postResponce.setPageNumber(pagePost.getNumber());
			postResponce.setPageSize(pagePost.getSize());
			postResponce.setTotalElement(pagePost.getTotalElements());
				postResponce.setTotalPage(pagePost.getTotalPages());
				postResponce.setLastPage(pagePost.isLast());
				return postResponce;

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
		List<Post> allPost = this.repo.findByTitleContaining(keyword);
		 List<PostDto>postDtoList =  allPost.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());


		return postDtoList;
	}

}
