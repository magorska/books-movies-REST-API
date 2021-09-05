package com.booksmoviesapp.service;

import com.booksmoviesapp.domain.MovieDbSearched;
import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.moviedb.client.MovieDbClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieDbClientService {

    private final MovieDbClient movieDbClient;

    public List<MovieDbSearchedDto> searchedList(String keyword) {
        return movieDbClient.getMovieDbSearchList(keyword);
    }

    public MovieDbSearchedDto latestMovie() {
        return movieDbClient.getMovieDbLatest();
    }

    public List<MovieDbSearchedDto> upComingMovies() {
        return movieDbClient.getMovieDbUpComingList();
    }

    public List<MovieDbSearchedDto> topRated() {
        return movieDbClient.getMovieDbTopRatedList();
    }

    public List<MovieDbSearchedDto> dayTrending() {
        return movieDbClient.getMovieDbDayTrendingList();
    }

    public List<MovieDbSearchedDto> weekTrending() {
        return movieDbClient.getMovieDbWeekTrendingList();
    }
}
