package com.example.crud_web_app.service;

import com.example.crud_web_app.dto.CreateBookDTO;
import com.example.crud_web_app.model.Book;
import com.example.crud_web_app.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org .mockito.Mockito.*;

public class BookServiceTest {
    private final BookRepository repository = mock(BookRepository.class);
    private final BookService service = new BookService(repository);

    @Test
    void shouldAddBook() {
        CreateBookDTO dto = new CreateBookDTO(
                "Test Title",
                "Test Desc",
                LocalDate.now(),
                "Author",
                "123"
        );

        service.addBook(dto);

        verify(repository, times(1)).save(any(Book.class));
    }

    @Test
    void shouldReturnAllBooks() {
        Book book = new Book();;
        book.setTitle("Test");

        when(repository.findAll()).thenReturn(List.of(book));
        var result = service.getAllBooks();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getTitle()).isEqualTo("Test");
    }
}
