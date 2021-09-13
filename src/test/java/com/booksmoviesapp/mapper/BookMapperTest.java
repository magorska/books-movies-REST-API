package com.booksmoviesapp.mapper;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.domain.dto.BookDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    @Test
    void testMapToBook() {
        //Given
        BookMapper bookMapper = new BookMapper();
        BookDto book = new BookDto.BookBuilder()
                .bookId(1L)
                .title("title")
                .author("author")
                .releaseYear(2020)
                .isbn(1L)
                .pages(20)
                .build();
        //When
        Book mappedBook = bookMapper.mapToBook(book);
        //Then
        assertEquals(1L, mappedBook.getBookId());
        assertEquals("title", mappedBook.getTitle());
        assertEquals("author", mappedBook.getAuthor());
        assertEquals(2020, mappedBook.getReleaseYear());
        assertEquals(1L, mappedBook.getIsbn());
        assertEquals(20, mappedBook.getPages());
    }
    @Test
    void testMapToBookDto() {
        //Given
        BookMapper bookMapper = new BookMapper();
        Review review = new Review();
        Book book = new Book(1L, "title", "author", 2020,
                1L, 20, review);
        //When
        BookDto mappedBookDto = bookMapper.mapToBookDto(book);
        //Then
        assertEquals(1L, mappedBookDto.getBookId());
        assertEquals("title", mappedBookDto.getTitle());
        assertEquals("author", mappedBookDto.getAuthor());
        assertEquals(2020, mappedBookDto.getReleaseYear());
        assertEquals(1L, mappedBookDto.getIsbn());
        assertEquals(20, mappedBookDto.getPages());
    }
    @Test
    void testMapToBookDtoList() {
        //Given
        BookMapper bookMapper = new BookMapper();
        Book book = new Book(1L, "title", "author", 2020,
                1L, 20, new Review());
        List<Book> bookList = Arrays.asList(book);
        //When
        List<BookDto> mappedBookList = bookMapper.mapToBookDtoList(bookList);
        //Then
        assertEquals(1, mappedBookList.size());
        assertEquals(1L, mappedBookList.get(0).getBookId());
        assertEquals("title", mappedBookList.get(0).getTitle());
        assertEquals("author", mappedBookList.get(0).getAuthor());
        assertEquals(2020, mappedBookList.get(0).getReleaseYear());
        assertEquals(1L, mappedBookList.get(0).getIsbn());
        assertEquals(20, mappedBookList.get(0).getPages());
    }
}