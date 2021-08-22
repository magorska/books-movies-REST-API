package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Movie;
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
    public void getMovie() {}

    @PostMapping(path = "createMovie")
    public void createMovie() {}

    @PutMapping(path= "updateMovie")
    public void updateMovie() {}

    @DeleteMapping(path = "deleteMovie")
    public void deleteMovie() {}
}
