package com.booksmoviesapp.domain.dto;

import com.booksmoviesapp.domain.Category;
import com.booksmoviesapp.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class MovieDto {

    private Long movieId;
    private String title;
    private String director;
    private int releaseYear;
    private Review review;
    private Category category;

    public static class MovieBuilder {

        private Long movieId;
        private String title;
        private String director;
        private int releaseYear;
        private Review review;
        private Category category;

        public MovieBuilder movieId(Long movieId) {
            this.movieId = movieId;
            return this;
        }

        public MovieBuilder title(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder director(String director) {
            this.director = director;
            return this;
        }

        public MovieBuilder releaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public MovieBuilder review(Review review) {
            this.review = review;
            return this;
        }

        public MovieBuilder category(Category category) {
            this.category = category;
            return this;
        }

    }

    public MovieDto(Long movieId, String title, String director, int releaseYear, Review review, Category category) {
        this.movieId = movieId;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.review = review;
        this.category = category;
    }

    public MovieDto() {}

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}