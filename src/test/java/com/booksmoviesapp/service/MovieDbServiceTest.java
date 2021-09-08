package com.booksmoviesapp.service;

import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.MovieCategory;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.repository.MovieRepository;
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
class MovieDbServiceTest {

    @InjectMocks
    private MovieDbService movieDbService;

    @Mock
    private MovieRepository movieRepository;

    @Test
    void testGetAllMovies() {
        //Given
        Movie movie = new Movie(1L, "title", "director", 2020, new Review(), MovieCategory.ACTION);
        List<Movie> moviesList = Arrays.asList(movie);
        when(movieRepository.findAll()).thenReturn(moviesList);

        //When
        List<Movie> testMovieList = movieDbService.getAllMovies();

        //Then
        assertEquals(1,testMovieList.size());
        assertEquals(1L, testMovieList.get(0).getMovieId());
        assertEquals("title", testMovieList.get(0).getTitle());
        assertEquals("director", testMovieList.get(0).getDirector());
        assertEquals(2020, testMovieList.get(0).getReleaseYear());

    }
    @Test
    void testSaveMovie() {
        //Given
        Movie movie = new Movie(1L, "title", "director", 2020, new Review(), MovieCategory.ACTION);
        when(movieRepository.save(movie)).thenReturn(movie);

        //When
        Movie savedMovie = movieDbService.saveMovie(movie);

        //Then
        assertEquals(1L, savedMovie.getMovieId());
        assertEquals("title", savedMovie.getTitle());
        assertEquals("director", savedMovie.getDirector());
        assertEquals(2020, savedMovie.getReleaseYear());

    }

    @Test
    void testGetMovie() {
        // Given
        Movie movie = new Movie(1L, "title", "director", 2020, new Review(), MovieCategory.ACTION);
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));

        //When
        Optional<Movie> testMovie = movieDbService.getMovie(1L);

        //Then
        assertEquals(movie, testMovie.get());
        assertTrue(testMovie.isPresent());
    }
    @Test
    void testDeleteMovie() {
        //Given
        Movie movie = new Movie(1L, "title", "director", 2020, new Review(), MovieCategory.ACTION);

        //When
        movieDbService.deleteMovie(1L);

        //Then
        verify(movieRepository, times(1)).deleteById(1L);
    }


}