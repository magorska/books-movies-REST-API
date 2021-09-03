package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.MovieDbSearched;
import com.booksmoviesapp.domain.dto.MovieDbSearchedListDto;
import com.booksmoviesapp.moviedb.client.MovieDbClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movieDb")
@RequiredArgsConstructor
public class MovieDbController {

    private final MovieDbClient movieDbClient;
    private final MovieDbSearchedListDto movieDbSearchedListDto;
    private final MovieDbSearched movieDbSearched;

    @GetMapping("/searchList")
    public void getSearch(String keyWord) {

        List<MovieDbSearchedListDto> searched = movieDbClient.getMovieDbSearchList(keyWord);

        searched.forEach(movieDbSearchedListDto -> System.out.println(movieDbSearchedListDto.getPages()));
        System.out.println("Movies on this pages");
        movieDbSearchedListDto.getMovieList().forEach(movieDbSearched -> {
            System.out.println(movieDbSearched.getId() + " - " + movieDbSearched.getTitle() + " - " + movieDbSearched.getRelease_date());
        });

    }

    @GetMapping("/searchMovie")
    public void getMovie() {

    }



}
