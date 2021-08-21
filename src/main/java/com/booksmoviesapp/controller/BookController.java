package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    public List<Book> getAllBooks() {
        return new ArrayList<>();
    }

    public void getBook() {}

    public void createBook() {}

    public void updateBook() {}

    public void deleteBook() {}

}
