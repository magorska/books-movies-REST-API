package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.domain.dto.ReviewDto;
import com.booksmoviesapp.mapper.ReviewMapper;
import com.booksmoviesapp.service.ReviewDbService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(ReviewController.class)
class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ReviewDbService reviewDbService;

    @Mock
    private ReviewMapper reviewMapper;

    @Test
    void shouldGetReviews() throws Exception {
        //Given
        ReviewDto reviewDto = new ReviewDto(1L, 5, "review", new Book(), new Movie());
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        reviewDtoList.add(reviewDto);

        when(reviewMapper.mapToReviewDtoList(anyList())).thenReturn(reviewDtoList);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/reviews/allReviews"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void shouldGetReview() throws Exception {
        //Given
        ReviewDto reviewDto = new ReviewDto(1L, 5, "review", new Book(), new Movie());
        Review review = new Review(1L, 5, "review", new Book(), new Movie());

        when(reviewMapper.mapToReviewDto(review)).thenReturn(reviewDto);
        when(reviewDbService.getReview(1L)).thenReturn(Optional.of(review));

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/reviews/1"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.reviewId", is(1)));
    }

    @Test
    public void shouldDeleteReview() throws Exception {
        //Given
        Review review = new Review(1L, 5, "review", new Book(), new Movie());

        when(reviewDbService.getReview(1L)).thenReturn(Optional.of(review));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/reviews/1"))
                .andExpect(status().is(200));
    }

    @Test
    void shouldUpdateReview() throws Exception {
        ReviewDto reviewDto = new ReviewDto(1L, 5, "review", new Book(), new Movie());
        Review review = new Review(1L, 5, "review", new Book(), new Movie());

        when(reviewMapper.mapToReview(reviewDto)).thenReturn(review);
        when(reviewMapper.mapToReviewDto(review)).thenReturn(reviewDto);
        when(reviewDbService.saveReview(review)).thenReturn(review);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(reviewDto);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(status().is(200));
    }

    @Test
    void shouldCreateReview() throws Exception {
        // Given
        ReviewDto reviewDto = new ReviewDto(1L, 5, "review", new Book(), new Movie());
        Review review = new Review(1L, 5, "review", new Book(), new Movie());

        when(reviewMapper.mapToReview(reviewDto)).thenReturn(review);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(reviewDto);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());

        verify(reviewDbService, times(1)).saveReview(review);
    }

}