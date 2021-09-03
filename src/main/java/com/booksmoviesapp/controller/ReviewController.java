package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.domain.dto.ReviewDto;
import com.booksmoviesapp.mapper.ReviewMapper;
import com.booksmoviesapp.service.ReviewDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewDbService reviewDbService;
    private final ReviewMapper reviewMapper;

    @GetMapping(path = "getAllReviews")
    public List<ReviewDto> getAllReviews() {
        return reviewMapper.mapToReviewDtoList(reviewDbService.getAllReviews());
    }

    @GetMapping(path = "getReview")
    public ReviewDto getReview(@RequestParam Long reviewId) throws ReviewNotFoundException {
        return reviewMapper.mapToReviewDto(reviewDbService.getReview(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("Review with id: " + reviewId + " not found.")));
    }

    @PostMapping(path = "createReview")
    public void createReview(@RequestBody ReviewDto reviewDto) {
        Review review = reviewMapper.mapToReview(reviewDto);
        reviewDbService.saveReview(review);
    }

    @PutMapping(path = "updateReview")
    public ReviewDto updateReview(@RequestBody ReviewDto reviewDto) {
        Review review = reviewMapper.mapToReview(reviewDto);
        Review savedReview = reviewDbService.saveReview(review);
        return reviewMapper.mapToReviewDto(savedReview);
    }

    @DeleteMapping(path = "deleteReview")
    public void deleteReview(@RequestParam Long reviewId) {
        reviewDbService.deleteReview(reviewId);
    }
}
