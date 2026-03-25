package com.example.crud_web_app;

import com.example.crud_web_app.dto.CreateBookDTO;
import com.example.crud_web_app.service.BookService;
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

    // Lägg till 5 böcker som testdata i H2-databasen
    @Bean
    public CommandLineRunner init(BookService service) {
        return args -> {
            CreateBookDTO b1 = new CreateBookDTO("The Hobbit", "A fantasy novel", LocalDate.of(1937, 9, 21), "J.R.R. Tolkien", "978-0261103344");
            CreateBookDTO b2 = new CreateBookDTO("1984", "Dystopian novel", LocalDate.of(1949, 6, 8), "George Orwell", "978-0451524935");
            CreateBookDTO b3 = new CreateBookDTO("To Kill a Mockingbird", "Classic novel", LocalDate.of(1960, 7, 11), "Harper Lee", "978-0061120084");
            CreateBookDTO b4 = new CreateBookDTO("Pride and Prejudice", "Romantic novel", LocalDate.of(1813, 1, 28), "Jane Austen", "978-1503290563");
            CreateBookDTO b5 = new CreateBookDTO("The Great Gatsby", "Novel set in 1920s", LocalDate.of(1925, 4, 10), "F. Scott Fitzgerald", "978-0743273565");

            service.addBook(b1);
            service.addBook(b2);
            service.addBook(b3);
            service.addBook(b4);
            service.addBook(b5);
        };
    }
}