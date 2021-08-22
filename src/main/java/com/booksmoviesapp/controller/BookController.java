package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Book;
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
    public void getBook() {}

    @PostMapping(path = "createBook")
    public void createBook() {}

    @PutMapping(path = "updateBook")
    public void updateBook() {}

    @DeleteMapping(path = "deleteBook")
    public void deleteBook() {}

}
