package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.domain.dto.ReviewDto;
import com.booksmoviesapp.mapper.ReviewMapper;
import com.booksmoviesapp.service.ReviewDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewDbService reviewDbService;
    private final ReviewMapper reviewMapper;

    @GetMapping(path = "/reviews/allReviews")
    public List<ReviewDto> getAllReviews() {
        return reviewMapper.mapToReviewDtoList(reviewDbService.getAllReviews());
    }

    @GetMapping(path = "/reviews/{reviewId}")
    public ReviewDto getReview(@PathVariable Long reviewId) throws ReviewNotFoundException {
        return reviewMapper.mapToReviewDto(reviewDbService.getReview(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("Review with id: " + reviewId + " not found.")));
    }

    @PostMapping(path = "/reviews")
    public void createReview(@RequestBody ReviewDto reviewDto) {
        Review review = reviewMapper.mapToReview(reviewDto);
        reviewDbService.rate(review.getReviewId());
        reviewDbService.saveReview(review);
    }

    @PutMapping(path = "/reviews")
    public ReviewDto updateReview(@RequestBody ReviewDto reviewDto) {
        Review review = reviewMapper.mapToReview(reviewDto);
        Review savedReview = reviewDbService.saveReview(review);
        savedReview.setRating(review.getRating());
        return reviewMapper.mapToReviewDto(savedReview);
    }

    @DeleteMapping(path = "/reviews/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        reviewDbService.deleteReview(reviewId);
    }
}
