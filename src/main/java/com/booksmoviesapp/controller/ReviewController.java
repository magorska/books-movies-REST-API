package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.domain.dto.ReviewDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/reviews")
public class ReviewController {

    @GetMapping(path = "getAllReviews")
    public List<Review> getAllReviews() {
        return new ArrayList<>();
    }

    @GetMapping(path = "getReview")
    public ReviewDto getReview(Long reviewId) {
        return new ReviewDto(1L, 1.1, "review", new Book(), new Movie());
    }

    @PostMapping(path = "createReview")
    public void createReview(ReviewDto reviewDto) {}

    @PutMapping(path = "updateReview")
    public ReviewDto updateReview(ReviewDto reviewDto) {
        return new ReviewDto(1L, 1.1, "review", new Book(), new Movie());
    }

    @DeleteMapping(path = "deleteReview")
    public void deleteReview(Long reviewId) {}
}
