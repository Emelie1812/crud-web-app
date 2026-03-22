package com.example.crud_web_app.service;

import com.example.crud_web_app.model.Book;
import com.example.crud_web_app.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public void addBook(Book book) {
        repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}