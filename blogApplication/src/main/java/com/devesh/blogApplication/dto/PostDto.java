package com.devesh.blogApplication.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDto {
	private Integer postId;
	private String title;
	private String content;
	private Date date;
	private Boolean isDeleted;

}
