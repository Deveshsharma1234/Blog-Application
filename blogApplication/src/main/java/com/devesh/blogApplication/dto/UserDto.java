package com.devesh.blogApplication.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.devesh.blogApplication.entity.Role;

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
	@NotNull
	@Size(min = 4 ,message = "User Name must be of min 4 character!")
	private String name;
	@Email(message = "Email is not valid!!")
	private String email;
	@NotNull
	@Size(min = 10, message = "Write about your self char must be 10 character or more!!")
	private String about;
	@NotNull
	@Size(min = 9, max = 12, message = "Enter vlaid phone no.")
	private String phoneNo;
	@NotNull

	private String password;
	
	private Role role;


}
