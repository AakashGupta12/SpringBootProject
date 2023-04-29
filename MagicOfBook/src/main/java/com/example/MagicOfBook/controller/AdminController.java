package com.example.MagicOfBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MagicOfBook.entity.Admin;
import com.example.MagicOfBook.entity.Book;
import com.example.MagicOfBook.service.AdminService;
import com.example.MagicOfBook.service.BookService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/login")
	public void login(@RequestBody Admin admin) throws Exception {
		adminService.authenticate(admin);
	}
	
	@PostMapping("/register")
	public Admin register(@RequestBody Admin admin) throws Exception{
		return adminService.registerAdmin(admin);
	}
	
	@GetMapping("/books")
    public ResponseEntity<List<Book>> listBooks() {
        List<Book> books = bookService.listBooks();
        return ResponseEntity.ok(books);
    }
	
	@GetMapping("/books/searchById/{id}")
    public ResponseEntity<Book> searchById(@PathVariable int id) {
        Book book = bookService.searchById(id);
        return ResponseEntity.ok(book);
    }
    
    @GetMapping("/books/searchByAuthor/{author}")
    public ResponseEntity<List<Book>> searchByAuthor(@PathVariable String author) {
        List<Book> books = bookService.searchByAuthor(author);
        return ResponseEntity.ok(books);
    }
	
    @PostMapping("/books/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/books/delete/{id}")
	public void deleteBookById(@PathVariable int id) {
		bookService.deleteBookById(id);
	}
    
    @PutMapping("/books/update/{id}")
   	public ResponseEntity<Book> updateBookById(@PathVariable int id,@RequestBody Book book) {
   		return new ResponseEntity<>(bookService.updateBookById(id,book),HttpStatus.CREATED);
   	}
	
}
