package com.booksmoviesapp.mapper;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.domain.dto.ReviewDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewMapperTest {

    @Test
    void testMapToReview() {
        //Given
        ReviewMapper reviewMapper = new ReviewMapper();
        ReviewDto review = new ReviewDto.ReviewBuilder()
                .reviewId(1L)
                .rating(1)
                .review("review")
                .build();
        //When
        Review mappedReview = reviewMapper.mapToReview(review);
        //Then
        assertEquals(1L, mappedReview.getReviewId());
        assertEquals(1, mappedReview.getRating());
        assertEquals("review", mappedReview.getReview());
    }
    @Test
    void testMapToReviewDto() {
        //Given
        ReviewMapper reviewMapper = new ReviewMapper();
        Review review = new Review(1L, 1, "review", new Book(), new Movie());
        //When
        ReviewDto mappedReviewDto = reviewMapper.mapToReviewDto(review);
        //Then
        assertEquals(1L, mappedReviewDto.getReviewId());
        assertEquals(1, mappedReviewDto.getRating());
        assertEquals("review", mappedReviewDto.getReview());
    }
    @Test
    void testMapToReviewDtoList() {
        //Given
        ReviewMapper reviewMapper = new ReviewMapper();
        Review review = new Review(1L, 1, "review", new Book(), new Movie());
        List<Review> reviewList = Arrays.asList(review);
        //When
        List<ReviewDto> mappedReviewList = reviewMapper.mapToReviewDtoList(reviewList);
        //Then
        assertEquals(1, mappedReviewList.size());
        assertEquals(1L,mappedReviewList.get(0).getReviewId());
        assertEquals(1, mappedReviewList.get(0).getRating());
        assertEquals("review", mappedReviewList.get(0).getReview());
    }

}