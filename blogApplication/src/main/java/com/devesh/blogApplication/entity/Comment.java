package com.devesh.blogApplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	private String comment;
	private Boolean isDeleted;





}
