package com.devesh.blogApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter

@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
	private String resourceName;
	private String fieldName;
	private Integer fieldValue;
	public ResourceNotFoundException(String resourceName , String fieldName, Integer value) {
		super(String.format("%s not found with %s: %s", resourceName, fieldName, value));
		System.out.println("ResourceNot found Exceprion Class------->>>"+":  " +resourceName +":  "+ fieldName+ ":  " + value);
		System.out.println(resourceName+ " Not found with  with " + fieldName + ": " +  value);
		this.fieldName = fieldName;
		this.fieldValue = value;
		this.resourceName = resourceName;
		
	}
	
	

}
