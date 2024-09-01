package com.devesh.blogApplication.service;

import com.devesh.blogApplication.dto.CategoryDto;

public interface CategoryService {
	CategoryDto createComment(CategoryDto commentDto);
	void deleteCategory(Integer categoryId);

}
