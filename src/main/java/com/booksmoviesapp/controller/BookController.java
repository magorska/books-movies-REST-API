package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Category;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.domain.dto.BookDto;
import com.booksmoviesapp.mapper.BookMapper;
import com.booksmoviesapp.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookDbService bookDbService;
    private final BookMapper bookMapper;

    @GetMapping(path = "getAllBooks")
    public List<BookDto> getAllBooks() {
        return bookMapper.mapToBookDtoList(bookDbService.getAllBooks());
    }

    @GetMapping(path = "getBook")
    public BookDto getBook(@RequestParam Long bookId) throws BookNotFoundException {
        return bookMapper.mapToBookDto(bookDbService.getBook(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book of id: " + bookId + " not found.")));
    }

    @PostMapping(path = "createBook")
    public void createBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        bookDbService.saveBook(book);}

    @PutMapping(path = "updateBook")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        Book savedBook = bookDbService.saveBook(book);
        return bookMapper.mapToBookDto(savedBook);
    }

    @DeleteMapping(path = "deleteBook")
    public void deleteBook(@RequestParam Long bookId) {
        bookDbService.deleteBook(bookId);
    }

}
