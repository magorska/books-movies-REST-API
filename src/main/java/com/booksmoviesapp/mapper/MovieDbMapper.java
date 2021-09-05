package com.booksmoviesapp.mapper;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.MovieDbSearched;
import com.booksmoviesapp.domain.dto.BookDto;
import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
                movieDbSearched.getRelease_date(),
                movieDbSearched.getVoteAverage()
        );
    }

    public List<MovieDbSearchedDto> mapToMovieDbDtoList(final List<MovieDbSearched> movieDbSearched) {
        return movieDbSearched.stream()
                .map(movie -> new MovieDbSearchedDto(
                        movie.getId(), movie.getTitle(), movie.getOverview(), movie.getRelease_date(),
                        movie.getVoteAverage()
                ))
                .collect(Collectors.toList());
    }

}
