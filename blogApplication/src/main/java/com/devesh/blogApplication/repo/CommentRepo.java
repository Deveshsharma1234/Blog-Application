package com.devesh.blogApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devesh.blogApplication.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
