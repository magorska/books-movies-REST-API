package com.booksmoviesapp.mapper;

import com.booksmoviesapp.domain.MovieDbSearched;
import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MovieDbMapper {

    public MovieDbSearched mapToMovieDb(final MovieDbSearchedDto movieDbSearchedDto) {
        return new MovieDbSearched(
                movieDbSearchedDto.getId(),
                movieDbSearchedDto.getTitle(),
                movieDbSearchedDto.getOverview(),
                movieDbSearchedDto.getReleaseDate(),
                movieDbSearchedDto.getVoteAverage()
        );
    }

    public MovieDbSearchedDto mapToMovieDbDto(final MovieDbSearched movieDbSearched) {
        return new MovieDbSearchedDto(
                movieDbSearched.getId(),
                movieDbSearched.getTitle(),
                movieDbSearched.getOverview(),
                movieDbSearched.getReleaseDate(),
                movieDbSearched.getVoteAverage()
        );
    }

    public List<MovieDbSearchedDto> mapToMovieDbDtoList(final List<MovieDbSearched> movieDbSearched) {
        return movieDbSearched.stream()
                .map(movie -> new MovieDbSearchedDto(
                        movie.getId(), movie.getTitle(), movie.getOverview(), movie.getReleaseDate(),
                        movie.getVoteAverage()
                ))
                .collect(Collectors.toList());
    }

    public List<MovieDbSearched> mapToMovieDbList(final List<MovieDbSearchedDto> movieDbSearchedDto) {
        return movieDbSearchedDto.stream()
                .map(movie -> new MovieDbSearched(
                        movie.getId(), movie.getTitle(), movie.getOverview(), movie.getReleaseDate(),
                        movie.getVoteAverage()
                ))
                .collect(Collectors.toList());
    }

}
