package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Review;
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
    public void getReview() {}

    @PostMapping(path = "createReview")
    public void createReview() {}

    @PutMapping(path = "updateReview")
    public void updateReview() {}

    @DeleteMapping(path = "deleteReview")
    public void deleteReview() {}
}
