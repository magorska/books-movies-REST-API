package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.dto.BookDto;
import com.booksmoviesapp.mapper.BookMapper;
import com.booksmoviesapp.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookDbService bookDbService;
    private final BookMapper bookMapper;

    @GetMapping(path = "/books/allBooks")
    public List<BookDto> getAllBooks() {
        return bookMapper.mapToBookDtoList(bookDbService.getAllBooks());
    }

    @GetMapping(path = "/books/{bookId}")
    public BookDto getBook(@PathVariable Long bookId) throws BookNotFoundException {
        return bookMapper.mapToBookDto(bookDbService.getBook(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book of id: " + bookId + " not found.")));
    }

    @PostMapping(path = "/books")
    public void createBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        bookDbService.saveBook(book);}

    @PutMapping(path = "/books")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        Book savedBook = bookDbService.saveBook(book);
        return bookMapper.mapToBookDto(savedBook);
    }

    @DeleteMapping(path = "/books/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookDbService.deleteBook(bookId);
    }

}
