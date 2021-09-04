package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.dto.MovieDto;
import com.booksmoviesapp.mapper.MovieMapper;
import com.booksmoviesapp.service.MovieDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieDbService movieDbService;
    private final MovieMapper movieMapper;

    @GetMapping(path = "getAllMovies")
    public List<MovieDto> getAllMovies() {
        return movieMapper.mapToMovieDtoList(movieDbService.getAllMovies());
    }

    @GetMapping(path = "getMovie")
    public MovieDto getMovie(@RequestParam Long movieId) throws MovieNotFoundException {
        return movieMapper.mapToMovieDto(movieDbService.getMovie(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie with id: " + movieId + " not found.")));
    }

    @PostMapping(path = "createMovie")
    public void createMovie(@RequestBody MovieDto movieDto) {
        Movie movie = movieMapper.mapToMovie(movieDto);
        movieDbService.saveMovie(movie);
    }

    @PutMapping(path= "updateMovie")
    public MovieDto updateMovie(@RequestBody MovieDto movieDto) {
        Movie movie = movieMapper.mapToMovie(movieDto);
        Movie savedMovie = movieDbService.saveMovie(movie);
        return movieMapper.mapToMovieDto(savedMovie);
    }

    @DeleteMapping(path = "deleteMovie")
    public void deleteMovie(@RequestParam Long movieId) {
        movieDbService.deleteMovie(movieId);
    }
}
