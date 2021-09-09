package com.booksmoviesapp.domain.dto;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Movie;

import java.util.Objects;

public class ReviewDto {

    private Long reviewId;
    private int rating;
    private String review;
    private Book book;
    private Movie movie;

    public static class ReviewBuilder {

        private Long reviewId;
        private int rating;
        private String review;
        private Book book;
        private Movie movie;

        public ReviewBuilder reviewId(Long reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public ReviewBuilder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public ReviewBuilder review(String review) {
            this.review = review;
            return this;
        }

        public ReviewBuilder book(Book book) {
            this.book = book;
            return this;
        }

        public ReviewBuilder movie(Movie movie) {
            this.movie = movie;
            return this;
        }

        public ReviewDto build() {
            return new ReviewDto(reviewId, rating, review, book, movie);
        }
    }

    public ReviewDto(Long reviewId, int rating, String review, Book book, Movie movie) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.review = review;
        this.book = book;
        this.movie = movie;
    }

    public ReviewDto() {}

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDto reviewDto = (ReviewDto) o;
        return rating == reviewDto.rating && Objects.equals(reviewId, reviewDto.reviewId) && Objects.equals(review, reviewDto.review) && Objects.equals(book, reviewDto.book) && Objects.equals(movie, reviewDto.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, rating, review, book, movie);
    }
}
