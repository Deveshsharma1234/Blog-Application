package com.devesh.blogApplication.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	@NotEmpty
	@Size(min = 3,message = "Invalid Title, Min 3 char")
	private String title;
	@Size(min = 7, max = 200,message = "Discription Size should be inside 7-200 characters!")
	@NotEmpty
	private String discription;
	

}
