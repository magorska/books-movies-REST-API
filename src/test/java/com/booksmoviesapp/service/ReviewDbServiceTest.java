package com.booksmoviesapp.service;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReviewDbServiceTest {

    @InjectMocks
    private ReviewDbService reviewDbService;

    @Mock
    private ReviewRepository reviewRepository;

    @Test
    void testGetAllReviews() {
        //Given
        Review review = new Review(1L, 5, "review", new Book(), new Movie());
        List<Review> reviewsList = Arrays.asList(review);
        when(reviewRepository.findAll()).thenReturn(reviewsList);

        //When
        List<Review> testReviewList = reviewDbService.getAllReviews();

        //Then
        assertEquals(1,testReviewList.size());
        assertEquals(1L, testReviewList.get(0).getReviewId());
        assertEquals(5, testReviewList.get(0).getRating());
        assertEquals("review", testReviewList.get(0).getReview());

    }
    @Test
    void testSaveReview() {
        //Given
        Review review = new Review(1L, 5, "review", new Book(), new Movie());
        when(reviewRepository.save(review)).thenReturn(review);

        //When
        Review savedReview = reviewDbService.saveReview(review);

        //Then
        assertEquals(1L, savedReview.getReviewId());
        assertEquals(5, savedReview.getRating());
        assertEquals("review", savedReview.getReview());

    }

    @Test
    void testGetReview() {
        // Given
        Review review = new Review(1L, 5, "review", new Book(), new Movie());
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));

        //When
        Optional<Review> testReview = reviewDbService.getReview(1L);

        //Then
        assertEquals(review, testReview.get());
        assertTrue(testReview.isPresent());
    }
    @Test
    void testDeleteReview() {
        //Given
        Review review = new Review(1L, 5, "review", new Book(), new Movie());

        //When
        reviewDbService.deleteReview(1L);

        //Then
        verify(reviewRepository, times(1)).deleteById(1L);
    }

    @Test
    void testRateCorrect() {
        //Given
        Review review = new Review(1L, 5, "review", new Book(), new Movie());
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));

        //When
        Review testReview = reviewDbService.rate(1L);

        //Then
        assertEquals(5, testReview.getRating());
    }

    @Test
    void testRateIncorrect() {
        //Given
        Review review = new Review(1L, 5, "review", new Book(), new Movie());
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));

        //When
        Review testReview = reviewDbService.rate(1L);

        //Then
        assertNotEquals(11, testReview.getRating());
    }

}