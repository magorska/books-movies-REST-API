package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.moviedb.client.facade.MovieDbFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1/movieDb")
@RequiredArgsConstructor
public class MovieDbClientController {

    private final MovieDbFacade movieDbFacade;

    @GetMapping("/searchList")
    public List<MovieDbSearchedDto> getSearch(String keyWord) {
        return movieDbFacade.searchedList(keyWord);
    }

    @GetMapping("/latest")
    public MovieDbSearchedDto getLatest() {
        return movieDbFacade.getLatest();
    }

    @GetMapping("/upcoming")
    public List<MovieDbSearchedDto> getUpComing() {
        return movieDbFacade.getUpComing();
    }

    @GetMapping("/topRated")
    public List<MovieDbSearchedDto> getTopRated() {
        return movieDbFacade.getTopRated();
    }

    @GetMapping("/dayTrending")
    public List<MovieDbSearchedDto> getDayTrending() {
        return movieDbFacade.getDayTrending();
    }

    @GetMapping("/weekTrending")
    public List<MovieDbSearchedDto> getWeekTrending() {
        return movieDbFacade.getWeekTrending();

    }
}
