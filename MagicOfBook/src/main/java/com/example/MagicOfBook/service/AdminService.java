package com.example.MagicOfBook.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MagicOfBook.dao.AdminRepository;
import com.example.MagicOfBook.dao.BookRepository;
import com.example.MagicOfBook.entity.Admin;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	public Admin authenticate(Admin admin) throws Exception {
		Admin a=adminRepository.findByName(admin.getName());
		if(a.getPassword()==a.getPassword()) {
			System.out.println("Logged in successfully");
			return a;
		}
		else {
			throw new Exception("Invalid credentials");
		}
	}
	
	public Admin registerAdmin(Admin admin) throws Exception {
		Admin a=adminRepository.findByName(admin.getName());
		if(a!=null) {
			throw new Exception("Admin already exists with same name");
		}
		return adminRepository.save(admin);
	}

}
