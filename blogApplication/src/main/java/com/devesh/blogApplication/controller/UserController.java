	package com.devesh.blogApplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.blogApplication.dto.ApiResponce;
import com.devesh.blogApplication.dto.UserDto;
import com.devesh.blogApplication.service.implement.UserServiceImp;

import io.swagger.v3.oas.annotations.Parameter;


@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserServiceImp service;

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody  UserDto userDto) {
		UserDto createdUser = service.createUser(userDto);
		return  new  ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserDto>  getUserByid(@Parameter Integer id) {

			UserDto user =  service.getUserByid(id);
			return new ResponseEntity<>(user,HttpStatus.OK);



	}
	@GetMapping("/")
	public ResponseEntity<List<UserDto>>  getAllUser(){
		List<UserDto> list=  service.getAllUser();
		return  ResponseEntity.ok(list);

	}
	@PatchMapping("/deleteUser/{id}")
public ResponseEntity<?> deleteUser(@Parameter Integer userId) {
		service.deleteUser(userId);
		return new ResponseEntity(new ApiResponce("User deleted successfully", true),HttpStatus.OK);
	}


	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer id) {
		System.out.println("UserDto=---->"+ userDto.getName());
	    System.out.println("Controller ---> " + userDto.toString() + " id: " + id.toString());
	    UserDto updatedUSer = service.updateUser(userDto, id);
	    return  ResponseEntity.ok(updatedUSer);
	}

}
