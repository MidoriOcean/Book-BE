package com.sistemi.informativi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemi.informativi.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
