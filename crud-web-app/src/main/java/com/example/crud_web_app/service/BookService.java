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

    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + id));
    }

    public void updateBook(Long id, Book updatedBook) {
        Book book = getBookById(id);
        book.setTitle(updatedBook.getTitle());
        book.setDescription(updatedBook.getDescription());
        book.setReleaseDate(updatedBook.getReleaseDate());
        book.setAuthor(updatedBook.getAuthor());
        book.setIsbn(updatedBook.getIsbn());
        repository.save(book);
    }
}