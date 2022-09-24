package com.codewithShekhar.blog.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithShekhar.blog.exceptions.*;
import com.codewithShekhar.blog.dto.UserDto;
import com.codewithShekhar.blog.entities.User;
import com.codewithShekhar.blog.repositories.UserRepo;
import com.codewithShekhar.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser)	;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user=this.userRepo.findById(userId)
				    .orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepo.save(user); //saving the updates using user object
		UserDto userToDto1 = this.userToDto(updatedUser); //then converting user object to dto object by calling userToDto method
		return userToDto1;
	}    

	@Override
	public UserDto getUsersById(Integer userId) {
	
		User user=this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
	  
		List<User> users = this.userRepo.findAll();
		 List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void DeleteUser(Integer userId) {
	
		User user = this.userRepo.findById(userId)
		              .orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
	
		this.userRepo.delete(user);
	}

	public User dtoToUser(UserDto userDto) {
		User user =new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		
		return user;
			
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto =new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		
		userDto.setAbout(user.getAbout());
		userDto.setPassword(user.getPassword());
		
		return userDto;
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
