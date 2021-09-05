package com.booksmoviesapp.service;

import com.booksmoviesapp.controller.ReviewNotFoundException;
import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewDbService {

    private final ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review saveReview(final Review review) {
        return reviewRepository.save(review);
    }

    public Optional<Review> getReview(final Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public void rate(Long reviewId) {
        Optional<Review> rate = reviewRepository.findById(reviewId);
        Review toRate = rate.orElseThrow(() -> new ReviewNotFoundException("Review with id: " + reviewId + " not found."));
        int yourRate = toRate.getRating();
        if (yourRate  >= 1 && yourRate >= 10) {
            toRate.setRating(yourRate);
            System.out.println("You've rated it for: " + yourRate);
        } else {
            System.out.println("You have to rate between 1 and 10");
        }
    }

}
