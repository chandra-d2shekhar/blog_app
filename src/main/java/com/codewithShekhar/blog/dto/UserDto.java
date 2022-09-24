package com.codewithShekhar.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter

public class UserDto {

	private int id;
	private String email;
	private String name;
	private String password;
	private String about;
	
}
