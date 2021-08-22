package com.booksmoviesapp.domain.dto;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private Long categoryId;
    private String categoryName;
    private List<Book> booksCategory;
    private List<Movie> moviesCategory;
}
