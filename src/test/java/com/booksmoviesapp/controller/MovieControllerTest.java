package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.domain.dto.MovieDto;
import com.booksmoviesapp.mapper.MovieMapper;
import com.booksmoviesapp.service.MovieDbService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieDbService movieDbService;

    @MockBean
    private MovieMapper movieMapper;


    @Test
    void shouldGetMovies() throws Exception {
        //Given
        MovieDto movieDto = new MovieDto(1L, "title", "author", 2020, new Review());
        List<MovieDto> movieDtoList = new ArrayList<>();
        movieDtoList.add(movieDto);

        when(movieMapper.mapToMovieDtoList(anyList())).thenReturn(movieDtoList);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/movies/allMovies"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void shouldGetMovie() throws Exception {
        //Given
        MovieDto movieDto = new MovieDto(1L, "title", "author", 2020, new Review());
        Movie movie = new Movie(1L, "title", "author", 2020, new Review());

        when(movieMapper.mapToMovieDto(movie)).thenReturn(movieDto);
        when(movieDbService.getMovie(1L)).thenReturn(Optional.of(movie));

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/movies/1"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.movieId", is(1)));
    }

    @Test
    public void shouldDeleteMovie() throws Exception {
        //Given
        Movie movie = new Movie(1L, "title", "author", 2020, new Review());

        when(movieDbService.getMovie(1L)).thenReturn(Optional.of(movie));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/movies/1"))
                .andExpect(status().is(200));
    }

    @Test
    void shouldUpdateMovie() throws Exception {
        Movie movie = new Movie(1L, "title", "author", 2020, new Review());
        MovieDto movieDto = new MovieDto(1L, "title", "author", 2020, new Review());

        when(movieMapper.mapToMovie(movieDto)).thenReturn(movie);
        when(movieMapper.mapToMovieDto(movie)).thenReturn(movieDto);
        when(movieDbService.saveMovie(movie)).thenReturn(movie);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(movieDto);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(status().is(200));
    }

    @Test
    void shouldCreateMovie() throws Exception {
        // Given
        MovieDto movieDto = new MovieDto(1L, "title", "author", 2020, new Review());
        Movie movie = new Movie(1L, "title", "author", 2020, new Review());

        when(movieMapper.mapToMovie(movieDto)).thenReturn(movie);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(movieDto);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());

        verify(movieDbService, times(1)).saveMovie(movie);
    }

}