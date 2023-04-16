package com.example.MagicOfBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MagicOfBook.dao.UserRepository;
import com.example.MagicOfBook.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User authenticateUser(User user) throws Exception {
		User u1=userRepository.findByName(user.getName());
		if(u1.getPassword()==user.getPassword()) {
			System.out.println("Logged in successfully");
			return user;
		}
		else {
			throw new Exception("Invalid credentials");
		}
	}
	
	public User registerUser(User user) throws Exception {
		User u=userRepository.findByName(user.getName());
		if(u!=null) {
			throw new Exception("User already exists");
		}
		return userRepository.save(user);
	}
	
	
}
