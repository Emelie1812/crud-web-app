package com.example.crud_web_app.controller;

import com.example.crud_web_app.dto.CreateBookDTO;
import com.example.crud_web_app.dto.UpdateBookDTO;
import com.example.crud_web_app.exception.ResourceNotFoundException;
import com.example.crud_web_app.mapper.BookMapper;
import com.example.crud_web_app.model.Book;
import com.example.crud_web_app.service.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    // Visa formulär för att skapa bok
    @GetMapping("/create")
    public String createBookForm(Model model) {
        model.addAttribute("createBookDTO", new CreateBookDTO());
        return "create-book";
    }

    // Skapa bok
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute CreateBookDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "create-book"; // Returnera till formuläret om valideringsfel
        }
        service.addBook(dto);
        return "redirect:/";
    }

    // Visa formulär för redigering
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        try {
            Book book = service.getBookById(id);
            UpdateBookDTO dto = BookMapper.toUpdateDTO(book);
            model.addAttribute("book", dto);
            return "edit-book";
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            return "error";
        }
    }

    // Uppdatera bok
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id,
                             @Valid @ModelAttribute UpdateBookDTO dto,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "edit-book"; // Returnera till formuläret om valideringsfel
        }
        service.updateBook(id, dto);
        return "redirect:/";
    }

    // Ta bort bok
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return "redirect:/"; // Redirect för att uppdatera listan
    }
}