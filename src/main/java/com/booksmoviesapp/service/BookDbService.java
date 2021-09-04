package com.booksmoviesapp.service;

import com.booksmoviesapp.config.AdminConfig;
import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookDbService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBook(final Long bookId) {
        return bookRepository.findById(bookId);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }





}
