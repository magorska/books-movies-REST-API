package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Category;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.domain.dto.BookDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    @GetMapping(path = "getAllBooks")
    public List<Book> getAllBooks() {
        return new ArrayList<>();
    }

    @GetMapping(path = "getBook")
    public BookDto getBook(Long bookId) {
        return new BookDto(1L, "title", "author", 2020, 1L, 20, new Review(), new Category());
    }

    @PostMapping(path = "createBook")
    public void createBook(BookDto bookDto) {}

    @PutMapping(path = "updateBook")
    public BookDto updateBook(BookDto bookDto) {
        return new BookDto(1L, "title", "author", 2020, 1L, 20, new Review(), new Category());
    }

    @DeleteMapping(path = "deleteBook")
    public void deleteBook(Long bookId) {}

}
