package com.booksmoviesapp.service;

import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.moviedb.client.MovieDbClient;
import com.booksmoviesapp.scheduler.MovieDbScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieDbClientService {

    private final MovieDbClient movieDbClient;
    private final MovieDbScheduler movieDbScheduler;

    public List<MovieDbSearchedDto> searchedList(String keyword) {
        return movieDbClient.getMovieDbSearchList(keyword);
    }

    public MovieDbSearchedDto latestMovie() {
        return movieDbClient.getMovieDbLatest();
    }

    public List<MovieDbSearchedDto> upComingMovies() {
        return movieDbScheduler.saveUpComing();
    }

    public List<MovieDbSearchedDto> topRated() {
        return movieDbScheduler.saveTopRated();
    }

    public List<MovieDbSearchedDto> dayTrending() {
        return movieDbScheduler.saveDayTrending();
    }

    public List<MovieDbSearchedDto> weekTrending() {
        return movieDbScheduler.saveWeekTrending();
    }

}
