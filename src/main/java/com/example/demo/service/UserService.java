package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.model.User;
import com.example.demo.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto userRegistrationDto);
	void updateUser(User user);
	void deleteUser(long id);
	List<User> getAllUsers(); 
	User getUserByID(long id);
}
