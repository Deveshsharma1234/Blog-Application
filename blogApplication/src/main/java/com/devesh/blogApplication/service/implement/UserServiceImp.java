package com.devesh.blogApplication.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devesh.blogApplication.dto.UserDto;
import com.devesh.blogApplication.entity.User;
import com.devesh.blogApplication.exception.ResourceNotFoundException;
import com.devesh.blogApplication.repo.UserRepo;
import com.devesh.blogApplication.service.UserService;
@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserRepo repo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = this.dtoToUser(userDto);
		 User savedUser = repo.save(user);
		System.out.println("User saved");
		return this.userToDto(savedUser);
	}



	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
	    System.out.println("Service ---> " + userDto.toString() + userId.toString());

	    User user = repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
	    System.out.println("Service ---->(User found in db) " + user.toString());

	    user.setName(userDto.getName());
	    user.setPhoneNo(userDto.getPhoneNo());
	    user.setAbout(userDto.getAbout());
	    user.setEmail(userDto.getEmail());
	    user.setPassword(userDto.getPassword());

	    User updatedUser = repo.save(user);
	    System.out.println("Service ---->(Updated user saved in Db) " + updatedUser.toString());

	    return this.userToDto(updatedUser);
	}



	@Override
	public UserDto getUserByid(Integer userId) {
		// TODO Auto-generated method stub
		 User user= repo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		return this.userToDto(user);

	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<User>users = repo.findAll();
	   List<UserDto> userDtos=   users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;

	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = repo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id",userId));
		user.setIsDeleted(true);
		repo.save(user);

	}

	private User dtoToUser(UserDto userDto) {
//		User user = new User();
//		user.setUserId(userDto.getUserId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPhoneNo(userDto.getPhoneNo());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		User user = this.modelMapper.map(userDto, User.class);

		return user;

	}
	private UserDto userToDto(User user) {
//		UserDto userDto = new UserDto();
//		userDto.setUserId(user.getUserId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPhoneNo(user.getPhoneNo());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		UserDto userDto = this.modelMapper.map(user, UserDto.class);


		return userDto;


	}



}
