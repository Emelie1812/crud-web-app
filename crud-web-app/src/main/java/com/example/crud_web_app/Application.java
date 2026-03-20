package com.example.crud_web_app;

import com.example.crud_web_app.model.Book;
import com.example.crud_web_app.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initData(BookRepository repository) {
        return args -> {
            repository.save(new Book("Clean Code", "A Handbook of Agile Software Craftsmanship", LocalDate.of(2008, 8, 1), "Robert C. Martin", "9780132350884"));
            repository.save(new Book("Effective Java", "Best practices for the Java platform", LocalDate.of(2018, 1, 6), "Joshua Bloch", "9780134685991"));
        };
    }
}