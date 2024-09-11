package com.devesh.blogApplication.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devesh.blogApplication.entity.Category;
import com.devesh.blogApplication.entity.Post;
import com.devesh.blogApplication.entity.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
	List<Post>findByUser(User user);
	List<Post>findByCategory(Category category);
	List<Post>findByTitleContaining(String title);
	List<Post>findByTagContaining(String tag);

}
