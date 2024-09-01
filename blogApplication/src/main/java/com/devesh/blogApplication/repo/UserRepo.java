	package com.devesh.blogApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devesh.blogApplication.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
