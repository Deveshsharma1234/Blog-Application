package com.devesh.blogApplication.dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.devesh.blogApplication.entity.Category;
import com.devesh.blogApplication.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDto {

	private String title;
	private String content;
	 private String imageName;
	 private Date date;
	 private CategoryDto category;
	 private UserDto user;
	 
	
//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//	private LocalDateTime  date;
	

}
