package com.example.MagicOfBook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MagicOfBook.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	public Admin findByName(String name);
}
