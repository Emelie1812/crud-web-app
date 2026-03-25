package com.example.crud_web_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class UpdateBookDTO {

    private Long id;

    @NotBlank(message = "Titel måste anges")
    private String title;

    @NotBlank(message = "Beskrivning måste anges")
    private String description;

    @PastOrPresent(message = "Datum kan inte vara i framtiden")
    private LocalDate releaseDate;

    @NotBlank(message = "Författare måste anges")
    private String author;

    @NotBlank(message = "ISBN måste anges")
    private String isbn;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
