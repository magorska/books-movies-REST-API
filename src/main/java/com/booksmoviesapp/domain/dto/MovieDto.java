package com.booksmoviesapp.domain.dto;

import com.booksmoviesapp.domain.Category;
import com.booksmoviesapp.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private Long movieId;
    private String title;
    private String director;
    private int releaseYear;
    private Review review;
    private Category category;
}
