package com.booksmoviesapp.mapper;

import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieMapper {

    public Movie mapToMovie(final MovieDto movieDto) {
        return new Movie(
                movieDto.getMovieId(),
                movieDto.getTitle(),
                movieDto.getDirector(),
                movieDto.getReleaseYear(),
                movieDto.getReview()
        );
    }

    public MovieDto mapToMovieDto(final Movie movie) {
        return new MovieDto(
                movie.getMovieId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getReleaseYear(),
                movie.getReview()
        );
    }

    public List<MovieDto> mapToMovieDtoList(final List<Movie> movieList) {
        return movieList.stream()
                .map(this::mapToMovieDto)
                .collect(Collectors.toList());
    }
}
