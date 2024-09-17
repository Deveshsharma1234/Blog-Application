package com.devesh.blogApplication.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

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
	
//	-----------------------------------------------------------------------------------------------
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
	joinColumns = @JoinColumn(name = "user",referencedColumnName = "userId"),
	inverseJoinColumns = @JoinColumn(name ="role", referencedColumnName = "id"))
	private Set<Role>role = new HashSet<>();
	
//-------------------------------------------------------------------------------------------------------
	@OneToMany(mappedBy = "user" ,fetch =FetchType.EAGER,cascade = CascadeType.ALL )
	private List<Post> posts= new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Comment>comments = new ArrayList<>();






}
