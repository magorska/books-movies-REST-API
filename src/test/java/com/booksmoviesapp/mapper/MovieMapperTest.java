package com.booksmoviesapp.mapper;

import com.booksmoviesapp.domain.*;
import com.booksmoviesapp.domain.dto.MovieDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieMapperTest {

    @Test
    void testMapToMovie() {
        //Given
        MovieMapper movieMapper = new MovieMapper();
        MovieDto movie = new MovieDto.MovieBuilder()
                .movieId(1L)
                .title("title")
                .director("director")
                .releaseYear(2020)
                .build();
        //When
        Movie mappedMovie = movieMapper.mapToMovie(movie);
        //Then
        assertEquals(1L, mappedMovie.getMovieId());
        assertEquals("title", mappedMovie.getTitle());
        assertEquals("director", mappedMovie.getDirector());
        assertEquals(2020, mappedMovie.getReleaseYear());
    }
    @Test
    void testMapToMovieDto() {
        //Given
        MovieMapper movieMapper = new MovieMapper();
        Movie movie = new Movie(1L, "title", "director", 2020, new Review());
        //When
        MovieDto mappedMovieDto = movieMapper.mapToMovieDto(movie);
        //Then
        assertEquals(1L, mappedMovieDto.getMovieId());
        assertEquals("title", mappedMovieDto.getTitle());
        assertEquals("director", mappedMovieDto.getDirector());
        assertEquals(2020, mappedMovieDto.getReleaseYear());
    }
    @Test
    void testMapToMovieDtoList() {
        //Given
        MovieMapper movieMapper = new MovieMapper();
        Movie movie = new Movie(1L, "title", "director", 2020, new Review());
        List<Movie> movieList = Arrays.asList(movie);
        //When
        List<MovieDto> mappedMovieList = movieMapper.mapToMovieDtoList(movieList);
        //Then
        assertEquals(1, mappedMovieList.size());
        assertEquals(1L, mappedMovieList.get(0).getMovieId());
        assertEquals("title", mappedMovieList.get(0).getTitle());
        assertEquals("director", mappedMovieList.get(0).getDirector());
        assertEquals(2020, mappedMovieList.get(0).getReleaseYear());
    }

}