package com.sistemi.informativi.service;

import java.util.List;
import java.util.Map;

import com.sistemi.informativi.entity.Book;

public interface BookService {

public List<Book> findAllBooks() throws Exception;
	
	public Book findBookById(int id) throws Exception;
	
	public Book savedOrUpdated(Book book) throws Exception;
	
	public Map<String, Boolean> deleteBook(int id);
}
