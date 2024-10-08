package com.devesh.blogApplication.dto;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

	private Integer commentId;
	@Size(max= 100,message= "Character should be inside 50 char")
	private String comment;

}
