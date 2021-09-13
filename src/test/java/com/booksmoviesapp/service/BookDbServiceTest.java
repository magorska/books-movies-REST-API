package com.booksmoviesapp.service;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDbServiceTest {


    @InjectMocks
    private BookDbService bookDbService;

    @Mock
    private BookRepository bookRepository;

    @Test
    void testGetAllBooks() {
        //Given
        Book book = new Book(1L, "title", "author", 2020, 1L, 20, new Review());
        List<Book> bookList = Arrays.asList(book);
        when(bookRepository.findAll()).thenReturn(bookList);

        //When
        List<Book> testBookList = bookDbService.getAllBooks();

        //Then
        assertEquals(1,testBookList.size());
        assertEquals(1L, testBookList.get(0).getBookId());
        assertEquals("title", testBookList.get(0).getTitle());
        assertEquals("author", testBookList.get(0).getAuthor());
        assertEquals(2020, testBookList.get(0).getReleaseYear());
        assertEquals(1L, testBookList.get(0).getIsbn());
        assertEquals(20, testBookList.get(0).getPages());
    }
    @Test
    void testSaveBook() {
        //Given
        Book book = new Book(1L, "title", "author", 2020, 1L, 20, new Review());
        when(bookRepository.save(book)).thenReturn(book);

        //When
        Book savedBook = bookDbService.saveBook(book);

        //Then
        assertEquals(1L, savedBook.getBookId());
        assertEquals("title", savedBook.getTitle());
        assertEquals("author", savedBook.getAuthor());
        assertEquals(2020, savedBook.getReleaseYear());
        assertEquals(2020, savedBook.getReleaseYear());
        assertEquals(1L, savedBook.getIsbn());
        assertEquals(20, savedBook.getPages());

    }
    @Test
    void testGetBook() {
        // Given
        Book book = new Book(1L, "title", "author", 2020, 1L, 20, new Review());
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        //When
        Optional<Book> testBook = bookDbService.getBook(1L);

        //Then
        assertEquals(book, testBook.get());
        assertTrue(testBook.isPresent());
    }
    @Test
    void testDeleteBook() {
        //Given
        Book book = new Book(1L, "title", "author", 2020, 1L, 20, new Review());

        //When
        bookDbService.deleteBook(1L);

        //Then
        verify(bookRepository, times(1)).deleteById(1L);
    }

}