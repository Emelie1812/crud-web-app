package com.example.crud_web_app.controller;

import com.example.crud_web_app.model.Book;
import com.example.crud_web_app.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // Visa alla böcker
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "books";
    }

    // Lägg till bok
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, Model model) {
        service.addBook(book);
        model.addAttribute("books", service.getAllBooks());
        return "redirect:/"; // redirect så att sidan uppdateras
    }

    // Ta bort bok
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return "redirect:/"; // redirect för att uppdatera listan
    }

    // Uppdatera bok
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        Book book = service.getBookById(id);
        model.addAttribute("book", book);
        return "edit-book";
    }

    // Hantera uppdatering av bok
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        service.updateBook(id, book);
        return "redirect:/";
    }
}