package com.webapp.main.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.main.model.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
