package com.booksmoviesapp.domain.dto;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private Long reviewId;
    private double rating;
    private String review;
    private Book book;
    private Movie movie;

}
