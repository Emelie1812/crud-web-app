package com.example.crud_web_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @PastOrPresent
    private LocalDate releaseDate;

    @NotBlank
    private String author;

    @NotBlank
    private String isbn;

    // Tom konstruktor behövs för JPA
    public Book() {}

    // Parametriserad konstruktor för enkel initiering
    public Book(String title, String description, LocalDate releaseDate, String author, String isbn) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters och setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}