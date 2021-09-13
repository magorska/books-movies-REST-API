package com.booksmoviesapp.domain.dto;

import com.booksmoviesapp.domain.Review;

import java.util.Objects;

public class MovieDto {

    private Long movieId;
    private String title;
    private String director;
    private int releaseYear;
    private Review review;

    public static class MovieBuilder {

        private Long movieId;
        private String title;
        private String director;
        private int releaseYear;
        private Review review;

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

        public MovieDto build() {
            return  new MovieDto(movieId, title, director, releaseYear, review);
        }

    }

    public MovieDto(Long movieId, String title, String director, int releaseYear, Review review) {
        this.movieId = movieId;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.review = review;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDto movieDto = (MovieDto) o;
        return releaseYear == movieDto.releaseYear && Objects.equals(movieId, movieDto.movieId) && Objects.equals(title, movieDto.title) && Objects.equals(director, movieDto.director) && Objects.equals(review, movieDto.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, title, director, releaseYear, review);
    }
}
