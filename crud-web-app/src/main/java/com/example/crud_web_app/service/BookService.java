package com.example.crud_web_app.service;

import com.example.crud_web_app.dto.BookDTO;
import com.example.crud_web_app.dto.CreateBookDTO;
import com.example.crud_web_app.dto.UpdateBookDTO;
import com.example.crud_web_app.exception.ResourceNotFoundException;
import com.example.crud_web_app.mapper.BookMapper;
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

    public List<BookDTO> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(BookMapper::toDTO)
                .toList();
    }

    public void addBook(CreateBookDTO dto) {
        Book book = BookMapper.toEntity(dto);
        repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bok med ID " + id + " hittades inte."));
    }

    public void updateBook(Long id, UpdateBookDTO dto) {
        Book book = getBookById(id);
        BookMapper.updateEntity(book, dto);
        repository.save(book);
    }
}