package com.devesh.blogApplication.service;

import java.util.List;

import com.devesh.blogApplication.dto.UserDto;



public interface UserService {

	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto, Integer id);
	UserDto getUserByid(Integer id);
	List <UserDto> getAllUser();
	void deleteUser(Integer id);
}
