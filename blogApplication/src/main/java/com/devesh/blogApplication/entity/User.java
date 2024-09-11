package com.devesh.blogApplication.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Column(name = "user_name",length = 100,nullable = false)
	private String name;
	private String email;
	private String password;
	private String about;
	private String phoneNo;
	private Boolean isDeleted;

	@OneToMany(mappedBy = "user" ,fetch =FetchType.EAGER,cascade = CascadeType.ALL )
	private List<Post> posts= new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_Id",referencedColumnName = "userId")
	private List<Comment>comments = new ArrayList<>();






}
