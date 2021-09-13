package com.booksmoviesapp.mapper;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(bookDto.getBookId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getReleaseYear(),
                bookDto.getIsbn(),
                bookDto.getPages(),
                bookDto.getReview());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(book.getBookId(),
                book.getTitle(),
                book.getAuthor(),
                book.getReleaseYear(),
                book.getIsbn(),
                book.getPages(),
                book.getReview());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
