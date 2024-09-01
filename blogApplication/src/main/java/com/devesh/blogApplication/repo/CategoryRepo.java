package com.devesh.blogApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devesh.blogApplication.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
