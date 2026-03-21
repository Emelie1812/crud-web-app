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

    // Hämta alla böcker
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // Spara bok
    public void saveBook(Book book) {
        repository.save(book);
    }

    // Hämta bok via id
    public Book getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // Ta bort bok
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Lägg till bok
    public void addBook(Book book) {
        repository.save(book);
    }
}
