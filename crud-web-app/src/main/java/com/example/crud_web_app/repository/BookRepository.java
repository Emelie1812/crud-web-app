package com.example.crud_web_app.repository;

import com.example.crud_web_app.model.Book;
import org.springframework.data.repository.ListCrudRepository;

public interface BookRepository extends ListCrudRepository<Book, Long> {
}
