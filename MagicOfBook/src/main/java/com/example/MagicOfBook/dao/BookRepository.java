package com.example.MagicOfBook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MagicOfBook.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
	
	List<Book> findByAuthorContainingIgnoreCase(String author);
	
	List<Book> findByTitleContainingIgnoreCase(String title);
	
	List<Book> findByPublicationContainingIgnoreCase(String publication);
	
	List<Book> findByOrderByPriceAsc();
	
	void deleteById(int id);
}
