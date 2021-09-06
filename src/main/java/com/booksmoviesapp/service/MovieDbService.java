package com.booksmoviesapp.service;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.moviedb.client.MovieDbClient;
import com.booksmoviesapp.repository.BookRepository;
import com.booksmoviesapp.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieDbService {

    private final MovieRepository movieRepository;
    private final MovieDbClientService movieDbClientService;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie saveMovie(final Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> getMovie(final Long movieId) {
        return movieRepository.findById(movieId);
    }

    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

}
