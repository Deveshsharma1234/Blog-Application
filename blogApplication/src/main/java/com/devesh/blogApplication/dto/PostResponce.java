package com.devesh.blogApplication.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponce {

	private List<PostDto> contents;
	private int pageNumber;
	private int pageSize;
	private Long totalElement;
	private int totalPage;
	private Boolean lastPage;

}
