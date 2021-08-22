package com.booksmoviesapp.domain.dto;

import com.booksmoviesapp.domain.Category;
import com.booksmoviesapp.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long bookId;
    private String title;
    private String author;
    private int releaseYear;
    private Long isbn;
    private int pages;
    private Review review;
    private Category category;

}
