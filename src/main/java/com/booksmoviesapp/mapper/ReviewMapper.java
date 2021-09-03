package com.booksmoviesapp.mapper;

import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.domain.dto.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewMapper {

    public Review mapToReview(final ReviewDto reviewDto) {
        return new Review(
                reviewDto.getReviewId(),
                reviewDto.getRating(),
                reviewDto.getReview(),
                reviewDto.getBook(),
                reviewDto.getMovie()
        );
    }

    public ReviewDto mapToReviewDto(final Review review) {
        return new ReviewDto(
                review.getReviewId(),
                review.getRating(),
                review.getReview(),
                review.getBook(),
                review.getMovie()
        );
    }

    public List<ReviewDto> mapToReviewDtoList(final List<Review> reviewList) {
        return reviewList.stream()
                .map(this::mapToReviewDto)
                .collect(Collectors.toList());
    }
}
