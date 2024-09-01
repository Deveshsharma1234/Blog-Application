package com.devesh.blogApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devesh.blogApplication.entity.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

}
