package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Movie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/movies")
public class MovieController {

    public List<Movie> getAllMovies() {
        return new ArrayList<>();
    }

    public void getMovie() {}

    public void createMovie() {}

    public void updateMovie() {}

    public void deleteMovie() {}
}
