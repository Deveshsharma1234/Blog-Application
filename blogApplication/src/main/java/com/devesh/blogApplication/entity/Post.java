package com.devesh.blogApplication.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.devesh.blogApplication.dto.CategoryDto;
import com.devesh.blogApplication.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    
    private String title;
    
    @Column(length = 16000)
    private String content;  // Ensure this is stored as TEXT or equivalent in the database
    
    private Date date;
    
    private String imageName = "default.png";
    
    @Column(nullable = false)
    private Boolean isDeleted = false;  // Default value
    
    @ManyToOne
    private Category category;
    
    @ManyToOne
    private User user;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "post_Id",referencedColumnName = "postId")
    private List<Comment>comments = new ArrayList<>();
    
}

