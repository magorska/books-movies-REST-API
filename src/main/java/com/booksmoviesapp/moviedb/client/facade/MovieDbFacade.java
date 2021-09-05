package com.booksmoviesapp.moviedb.client.facade;

import com.booksmoviesapp.domain.MovieDbSearched;
import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.mapper.MovieDbMapper;
import com.booksmoviesapp.moviedb.client.MovieDbClient;
import com.booksmoviesapp.service.MovieDbClientService;
import com.booksmoviesapp.service.MovieDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieDbFacade {

    @Autowired
    private MovieDbClientService movieDbClientService;

    @Autowired
    private MovieDbMapper movieDbMapper;

    public List<MovieDbSearchedDto> searchedList(String keyword) {
        List<MovieDbSearched> searchedMovies = movieDbMapper.mapToMovieDbList(movieDbClientService.searchedList(keyword));
        List<MovieDbSearched> resultList = new ArrayList<>(searchedMovies);
        return movieDbMapper.mapToMovieDbDtoList(resultList);
    }

    public MovieDbSearchedDto getLatest() {

        MovieDbSearched latestMovie = movieDbMapper.mapToMovieDb(movieDbClientService.latestMovie());
        return movieDbMapper.mapToMovieDbDto(latestMovie);
    }

    public List<MovieDbSearchedDto> getUpComing() {
        List<MovieDbSearched> searchedList = movieDbMapper.mapToMovieDbList(movieDbClientService.upComingMovies());
        List<MovieDbSearched> resultUpComing = new ArrayList<>(searchedList);
        return movieDbMapper.mapToMovieDbDtoList(resultUpComing);
    }

    public List<MovieDbSearchedDto> getTopRated() {
        List<MovieDbSearched> searchedList = movieDbMapper.mapToMovieDbList(movieDbClientService.topRated());
        List<MovieDbSearched> resultTopRated = new ArrayList<>(searchedList);
        return movieDbMapper.mapToMovieDbDtoList(resultTopRated);

    }

    public List<MovieDbSearchedDto> getDayTrending() {
        List<MovieDbSearched> searchedList = movieDbMapper.mapToMovieDbList(movieDbClientService.dayTrending());
        List<MovieDbSearched> resultDayTrending = new ArrayList<>(searchedList);
        return movieDbMapper.mapToMovieDbDtoList(resultDayTrending);
    }

    public List<MovieDbSearchedDto> getWeekTrending() {
        List<MovieDbSearched> searchedList = movieDbMapper.mapToMovieDbList(movieDbClientService.weekTrending());
        List<MovieDbSearched> resultWeekTrending = new ArrayList<>(searchedList);
        return movieDbMapper.mapToMovieDbDtoList(resultWeekTrending);
    }
}
