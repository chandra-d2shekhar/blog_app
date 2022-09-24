package com.codewithShekhar.blog.services;

import java.util.List;

import com.codewithShekhar.blog.dto.UserDto;
import com.codewithShekhar.blog.entities.User;


public interface UserService {

	 UserDto createUser(UserDto user);
	 
	 UserDto updateUser(UserDto user,Integer userId);
	 
	 UserDto getUsersById(Integer userId);
	 
	 List<UserDto>getAllUsers();
	 
	 void DeleteUser(Integer userId);
	 
	
}
