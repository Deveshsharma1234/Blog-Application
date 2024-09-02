package com.devesh.blogApplication.service.implement;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devesh.blogApplication.dto.CategoryDto;
import com.devesh.blogApplication.entity.Category;
import com.devesh.blogApplication.exception.ResourceNotFoundException;
import com.devesh.blogApplication.repo.CategoryRepo;
import com.devesh.blogApplication.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {
	@Autowired
	CategoryRepo repo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category category = modelMapper.map(categoryDto, Category.class);
		repo.save(category);
		return this.modelMapper.map(category, CategoryDto.class);
		
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer id) {
		Category category = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category","id" ,+ id));
		category.setTitle(categoryDto.getTitle());
		category.setDiscription(categoryDto.getDiscription());
		repo.save(category);
		
	return	this.modelMapper.map(category, CategoryDto.class);
	
	}

	@Override
	public void deleteCategory(Integer categoryId) {
	Category cat = 	repo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","id",categoryId));
	repo.delete(cat);
		System.out.println("Category Deleted Succesfully");

	}

	@Override
	public CategoryDto getCategory(Integer id) {
		// TODO Auto-generated method stub
		Category cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","id",id));
		return this.modelMapper.map(cat, CategoryDto.class);	
	
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> allCategory = repo.findAll();
		 return  allCategory.stream().map((category)->this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		
	}

}
