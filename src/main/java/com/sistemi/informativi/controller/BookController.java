package com.sistemi.informativi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemi.informativi.entity.Book;
import com.sistemi.informativi.service.BookService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public List<Book> findAllTutorials() throws Exception{
		
		return bookService.findAllBooks();
	}
	
	@GetMapping("/book-id/{id}")
	public Book findTutorialById(@PathVariable int id) throws Exception {
		
		return bookService.findBookById(id);
	}
	
	@PostMapping("")
	public Book saveTutorial(@RequestBody Book book) throws Exception {
		
		return bookService.savedOrUpdated(book);
	}
	
	@PutMapping("")
	public Book updateTutorial(@RequestBody Book book) throws Exception {
		
		return bookService.savedOrUpdated(book);
	}
	
	@DeleteMapping("book-id/{id}")
	public Map<String, Boolean> deleteTutorial(@PathVariable int id){
		
		return bookService.deleteBook(id);
	} 
}
