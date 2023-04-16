package com.example.MagicOfBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MagicOfBook.entity.Book;
import com.example.MagicOfBook.entity.User;
import com.example.MagicOfBook.service.BookService;
import com.example.MagicOfBook.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/login")
	public void login(@RequestBody User user) throws Exception {
		userService.authenticateUser(user);
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user) throws Exception{
		return userService.registerUser(user);
	}
	
	 @GetMapping("/books")
	    public ResponseEntity<List<Book>> listBooks() {
	        List<Book> books = bookService.listBooks();
	        return ResponseEntity.ok(books);
	    }
	    
	    @GetMapping("/books/{author}")
	    public ResponseEntity<List<Book>> searchByAuthor(@PathVariable String author) {
	        List<Book> books = bookService.searchByAuthor(author);
	        return ResponseEntity.ok(books);
	    }
	    
	    @GetMapping("/books/{title}")
	    public ResponseEntity<List<Book>> searchByTitle(@PathVariable String title) {
	        List<Book> books = bookService.searchByAuthor(title);
	        return ResponseEntity.ok(books);
	    }
	    
	    @GetMapping("/books/{publication}")
	    public ResponseEntity<List<Book>> searchByPublication(@PathVariable String publication) {
	        List<Book> books = bookService.searchByPublication(publication);
	        return ResponseEntity.ok(books);
	    }
	    
	    @GetMapping("/books/{id}")
	    public ResponseEntity<Book> searchById(@PathVariable int id) {
	        Book book = bookService.searchById(id);
	        return ResponseEntity.ok(book);
	    }
	    
	    @GetMapping("/books")
	    public ResponseEntity<List<Book>> searchByPriceRange(@RequestParam int price_min, @RequestParam int price_max) {
	        List<Book> books = bookService.searchByPriceRange(price_min, price_max);
	        return ResponseEntity.ok(books);
	    }
	    
	    @GetMapping("/books/sort")
	    public ResponseEntity<List<Book>> sortByPriceAsc() {
	        List<Book> books = bookService.sortByPriceAsc();
	        return ResponseEntity.ok(books);
	    }
}
