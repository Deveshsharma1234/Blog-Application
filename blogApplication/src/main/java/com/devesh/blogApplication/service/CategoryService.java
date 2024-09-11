package com.devesh.blogApplication.service;

import java.util.List;

import com.devesh.blogApplication.dto.CategoryDto;

public interface CategoryService {
	//create
	CategoryDto createCategory	(CategoryDto commentDto);

	//update
	CategoryDto updateCategory(CategoryDto categroyDto ,Integer id);
	//delete
	void deleteCategory(Integer categoryId);
//	get
	CategoryDto getCategory(Integer id);

//	getAll
	List<CategoryDto>getAllCategory();
}
