package com.example.crud_web_app.mapper;

import com.example.crud_web_app.dto.CreateBookDTO;
import com.example.crud_web_app.model.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class BookMapperTest {

    @Test
    void shouldConvertCreateDTOToEntity() {
        CreateBookDTO dto = new CreateBookDTO(
                "Title",
                "Desc",
                LocalDate.now(),
                "Author",
                "123"
        );

        Book book = BookMapper.toEntity(dto);

        assertThat(book.getTitle()).isEqualTo("Title");
        assertThat(book.getAuthor()).isEqualTo("Author");
    }
}
