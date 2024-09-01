package com.devesh.blogApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.blogApplication.dto.UserDto;
import com.devesh.blogApplication.service.implement.UserServiceImp;

import io.swagger.v3.oas.annotations.Parameter;


@RestController
public class UserController {
	@Autowired
	UserServiceImp service;

	@PostMapping("/register")
	public void createUser( @RequestBody  UserDto userDto) {
		service.createUser(userDto);
	}
	@GetMapping("/getUserById/{id}")
	public UserDto  getUserByid(@Parameter Integer id) {
		return service.getUserByid(id);
		
	}
	@GetMapping("/getAllUser")
	public List<UserDto> getAllUser(){
		return service.getAllUser();
	}
	@PatchMapping("/deleteUser/{id}")
public void deleteUser(@Parameter Integer userId) {
		service.deleteUser(userId);
	}
	
	
	@PutMapping("/updateUser/{id}")
	public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Integer id) {
		System.out.println("UserDto=---->"+ userDto.getName());
	    System.out.println("Controller ---> " + userDto.toString() + " id: " + id.toString());
	    return service.updateUser(userDto, id);
	}

}
