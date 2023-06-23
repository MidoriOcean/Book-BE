package com.sistemi.informativi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemi.informativi.entity.Book;
import com.sistemi.informativi.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> findAllBooks() throws Exception {
		
		List<Book> books = new ArrayList<>();
		
		books = bookRepository.findAll();
		
		if(books.isEmpty()) {
			
			throw new Exception("Non sono presenti libri in elenco");
		}
		
		return books;
	}

	@Override
	public Book findBookById(int id) throws Exception {
		
		return bookRepository.findById(id).orElseThrow(()-> new Exception("Non esiste un libro con l' id specificato"));
	}

	@Override
	public Book savedOrUpdated(Book book) throws Exception {

		Book savedOrUpdated = bookRepository.save(book);
		
		if(!savedOrUpdated.getTitle().equals(book.getTitle())) {
			
			throw new Exception("L'entry non è stata salvata ( o aggiornata)");
		}
		
		return savedOrUpdated;
	}

	@Override
	public Map<String, Boolean> deleteBook(int id) {

		Map<String, Boolean> deletionMap = new HashMap<>();
		
		try {
			
			bookRepository.deleteById(id);
			deletionMap.put("Book Deletion", true);
		} catch(IllegalArgumentException ex) {
			
			ex.printStackTrace();
			deletionMap.put("Book Deletion", false);
		}
		
		return deletionMap;
	}

}
