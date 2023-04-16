package com.example.MagicOfBook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MagicOfBook.dao.BookRepository;
import com.example.MagicOfBook.entity.Book;

@Service
public class BookService {
	@Autowired
    private BookRepository bookRepository;
    
    public List<Book> listBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }
    
    public List<Book> searchByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthorContainingIgnoreCase(author);
        return books;
    }
    
    public List<Book> searchByTitle(String title) {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(title);
        return books;
    }
    
    public List<Book> searchByPublication(String publication) {
        List<Book> books = bookRepository.findByPublicationContainingIgnoreCase(publication);
        return books;
    }
    
    public Book searchById(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return book;
        } else {
            return null;
        }
    }
    
    public List<Book> searchByPriceRange(int price_min,int price_max) {
        List<Book> allBooks = bookRepository.findAll();
        List<Book> filteredBooks=new ArrayList<>();
        for(Book book:allBooks) {
        	if(book.getPrice()>=price_min && book.getPrice()<=price_max)
        		filteredBooks.add(book);
        }
        return filteredBooks;
    }
    
    public List<Book> sortByPriceAsc() {
        List<Book> books = bookRepository.findByOrderByPriceAsc();
        return books;
    }
    
    public Book addBook(Book book) {
    	return bookRepository.save(book);
    }
    
    public void deleteBookById(int id) {
    	bookRepository.deleteById(id);
	}
    
    public Book updateBookById(int id,Book newBook) {
    	Book b=bookRepository.findById(id).get();
    	b.setAuthor(newBook.getAuthor());
    	b.setPrice(newBook.getPrice());
    	b.setPublication(newBook.getPublication());
    	b.setTitle(newBook.getTitle());
    	return bookRepository.save(b);
	}
    
    
    
}
