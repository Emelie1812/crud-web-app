package com.example.crud_web_app;

import com.example.crud_web_app.service.BookService;
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
    CommandLineRunner runner(BookService service) {
        return args -> {

            Book b1 = new Book();
            b1.setTitle("The Hobbit");
            b1.setDescription("A fantasy adventure");
            b1.setReleaseDate(LocalDate.of(1937, 9, 21));
            b1.setAuthor("J.R.R. Tolkien");
            b1.setIsbn("9780261103344");

            Book b2 = new Book();
            b2.setTitle("1984");
            b2.setDescription("Dystopian society");
            b2.setReleaseDate(LocalDate.of(1949, 6, 8));
            b2.setAuthor("George Orwell");
            b2.setIsbn("9780451524935");

            Book b3 = new Book();
            b3.setTitle("To Kill a Mockingbird");
            b3.setDescription("Justice and racism");
            b3.setReleaseDate(LocalDate.of(1960, 7, 11));
            b3.setAuthor("Harper Lee");
            b3.setIsbn("9780061120084");

            Book b4 = new Book();
            b4.setTitle("The Great Gatsby");
            b4.setDescription("American dream critique");
            b4.setReleaseDate(LocalDate.of(1925, 4, 10));
            b4.setAuthor("F. Scott Fitzgerald");
            b4.setIsbn("9780743273565");

            Book b5 = new Book();
            b5.setTitle("The Alchemist");
            b5.setDescription("Follow your dreams");
            b5.setReleaseDate(LocalDate.of(1988, 4, 15));
            b5.setAuthor("Paulo Coelho");
            b5.setIsbn("9780061122415");

            service.addBook(b1);
            service.addBook(b2);
            service.addBook(b3);
            service.addBook(b4);
            service.addBook(b5);
        };
    }
}