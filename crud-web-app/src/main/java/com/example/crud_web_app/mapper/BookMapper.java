package com.example.crud_web_app.mapper;

import com.example.crud_web_app.dto.BookDTO;
import com.example.crud_web_app.dto.CreateBookDTO;
import com.example.crud_web_app.dto.UpdateBookDTO;
import com.example.crud_web_app.model.Book;

public class BookMapper {

    // Convert CreateBookDTO → Book (för att spara ny bok)
    public static Book toEntity(CreateBookDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setDescription(dto.getDescription());
        book.setReleaseDate(dto.getReleaseDate());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        return book;
    }

    // Convert UpdateBookDTO → Book (för att uppdatera befintlig bok)
    public static void updateEntity(Book book, UpdateBookDTO dto) {
        book.setTitle(dto.getTitle());
        book.setDescription(dto.getDescription());
        book.setReleaseDate(dto.getReleaseDate());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
    }

    // Convert Book → BookDTO (för vyer)
    public static BookDTO toDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setDescription(book.getDescription());
        dto.setReleaseDate(book.getReleaseDate());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        return dto;
    }

    public static UpdateBookDTO toUpdateDTO(Book book) {
        UpdateBookDTO dto = new UpdateBookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setDescription(book.getDescription());
        dto.setReleaseDate(book.getReleaseDate());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        return dto;
    }
}
