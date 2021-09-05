package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.moviedb.client.MovieDbClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movieDb")
@RequiredArgsConstructor
public class MovieDbClientController {

    private final MovieDbClient movieDbClient;

    @GetMapping("/searchList")
    public void getSearch(String keyWord) {

        List<MovieDbSearchedDto> searched = movieDbClient.getMovieDbSearchList(keyWord);

        searched.forEach(movieDbSearchedDto -> System.out.println(movieDbSearchedDto.getTitle() + "\n" +
                movieDbSearchedDto.getOverview() + "\n" + movieDbSearchedDto.getReleaseDate() +
                "\n" + movieDbSearchedDto.getVoteAverage()));
    }


    @GetMapping("/latest")
    public void getLatest() {
        MovieDbSearchedDto latestMovie = movieDbClient.getMovieDbLatest();

        latestMovie.toString();
    }

    @GetMapping("/upcoming")
    public void getUpComing() {

        List<MovieDbSearchedDto> searchedUpComing = movieDbClient.getMovieDbUpComingList();

        searchedUpComing.forEach(movieDbSearchedDto -> System.out.println(movieDbSearchedDto.getTitle() + "\n" +
                movieDbSearchedDto.getOverview() + "\n" + movieDbSearchedDto.getReleaseDate() +
                "\n" + movieDbSearchedDto.getVoteAverage()));
    }

    @GetMapping("/topRated")
    public void getTopRated() {

        List<MovieDbSearchedDto> searchedTopRated = movieDbClient.getMovieDbTopRatedList();

        searchedTopRated.forEach(movieDbSearchedDto -> System.out.println(movieDbSearchedDto.getTitle() + "\n" +
                movieDbSearchedDto.getOverview() + "\n" + movieDbSearchedDto.getReleaseDate() +
                "\n" + movieDbSearchedDto.getVoteAverage()));
    }

    @GetMapping("/dayTrending")
    public void getDayTrending() {

        List<MovieDbSearchedDto> searchedTopRated = movieDbClient.getMovieDbDayTrendingList();

        searchedTopRated.forEach(movieDbSearchedDto -> System.out.println(movieDbSearchedDto.getTitle() + "\n" +
                movieDbSearchedDto.getOverview() + "\n" + movieDbSearchedDto.getReleaseDate() +
                "\n" + movieDbSearchedDto.getVoteAverage()));
    }

    @GetMapping("/weekTrending")
    public void getWeekTrending() {

        List<MovieDbSearchedDto> searchedTopRated = movieDbClient.getMovieDbWeekTrendingList();

        searchedTopRated.forEach(movieDbSearchedDto -> System.out.println(movieDbSearchedDto.getTitle() + "\n" +
                movieDbSearchedDto.getOverview() + "\n" + movieDbSearchedDto.getReleaseDate() +
                "\n" + movieDbSearchedDto.getVoteAverage()));
    }
}
