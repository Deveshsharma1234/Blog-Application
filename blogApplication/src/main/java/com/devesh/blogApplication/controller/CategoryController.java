package com.devesh.blogApplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.blogApplication.dto.CategoryDto;
import com.devesh.blogApplication.service.implement.CategoryServiceImp;

import lombok.val;

@RestController
@RequestMapping("api/categorys")
public class CategoryController {
	
	@Autowired
	CategoryServiceImp service;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
	CategoryDto createdCategory = 	service.createCategory(categoryDto);
	return new ResponseEntity<>(createdCategory,HttpStatus.CREATED);	
	}
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody  CategoryDto categoryDto,@PathVariable Integer id){
		CategoryDto updated = service.updateCategory(categoryDto, id);
		return new ResponseEntity<CategoryDto>(updated , HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Integer id) {
		service.deleteCategory(id);
	}
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer id){
		 CategoryDto cate = service.getCategory(id);
		 return new ResponseEntity<CategoryDto>(cate,HttpStatus.ACCEPTED);
	}
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto>allCategory = service.getAllCategory();
		return new ResponseEntity(allCategory,HttpStatus.ACCEPTED);
	}

}
