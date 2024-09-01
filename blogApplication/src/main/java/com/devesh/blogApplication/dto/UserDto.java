package com.devesh.blogApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

	private int userId;

	private String name;
	private String email;
	private String about;
	private String phoneNo;
	private String password;


}
