
package com.devesh.blogApplication.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDto {

	private String title;
	private String content;
	 private String imageName;
	 private Date date;
	 private CategoryDto category;
	 private UserDto user;
	 private String tag;


//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//	private LocalDateTime  date;


}
