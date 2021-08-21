package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Review;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/reviews")
public class ReviewController {

    public List<Review> getAllReviews() {
        return new ArrayList<>();
    }

    public void getReview() {}

    public void createReview() {}

    public void updateReview() {}

    public void deleteReview() {}
}
