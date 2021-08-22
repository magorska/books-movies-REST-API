package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Category;
import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.domain.dto.MovieDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/movies")
public class MovieController {

    @GetMapping(path = "getAllMovies")
    public List<Movie> getAllMovies() {
        return new ArrayList<>();
    }

    @GetMapping(path = "getMovie")
    public MovieDto getMovie(Long movieId) {
        return new MovieDto(1L, "title", "director", 2020, new Review(), new Category());
    }

    @PostMapping(path = "createMovie")
    public void createMovie(MovieDto movieDto) {}

    @PutMapping(path= "updateMovie")
    public MovieDto updateMovie(MovieDto movieDto) {
        return new MovieDto(1L, "title", "director", 2020, new Review(), new Category());
    }

    @DeleteMapping(path = "deleteMovie")
    public void deleteMovie(Long movieId) {}
}
