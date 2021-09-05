package com.booksmoviesapp.moviedb.client;

import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MovieDbClient {

    private final RestTemplate restTemplate;

    @Value("${themoviedb.api.endpoint.prod}")
    private String movieDbEndpoint;

    @Value("${themoviedb.api.key}")
    private String movieDbKey;

    public List<MovieDbSearchedDto> getMovieDbSearchList(String partOfTitle) {

        URI url = UriComponentsBuilder.fromHttpUrl(movieDbEndpoint + "search/movie")
                .queryParam("api_key", movieDbKey)
                .queryParam("query", partOfTitle)
//                .queryParam("pages")
//                .queryParam("results", "id", "name")
                .build()
                .encode()
                .toUri();
        System.out.println(url);

        MovieDbSearchedDto[] searchResponse = restTemplate.getForObject(url, MovieDbSearchedDto[].class);

        return Optional.ofNullable(searchResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public MovieDbSearchedDto getMovieDbLatest() {

        URI url = UriComponentsBuilder.fromHttpUrl(movieDbEndpoint + "movie/latest")
                .queryParam("api_key", movieDbKey)
                .build()
                .encode()
                .toUri();
        System.out.println(url);

        MovieDbSearchedDto searchResponse = restTemplate.getForObject(url, MovieDbSearchedDto.class);

        return searchResponse;
    }

    public List<MovieDbSearchedDto> getMovieDbUpComingList() {

        URI url = UriComponentsBuilder.fromHttpUrl(movieDbEndpoint + "movie/upcoming")
                .queryParam("api_key", movieDbKey)
                .build()
                .encode()
                .toUri();
        System.out.println(url);

        MovieDbSearchedDto[] searchResponse = restTemplate.getForObject(url, MovieDbSearchedDto[].class);

        return Optional.ofNullable(searchResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public List<MovieDbSearchedDto> getMovieDbTopRatedList() {

        URI url = UriComponentsBuilder.fromHttpUrl(movieDbEndpoint + "movie/top_rated")
                .queryParam("api_key", movieDbKey)
                .build()
                .encode()
                .toUri();
        System.out.println(url);

        MovieDbSearchedDto[] searchResponse = restTemplate.getForObject(url, MovieDbSearchedDto[].class);

        return Optional.ofNullable(searchResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public List<MovieDbSearchedDto> getMovieDbDayTrendingList() {

        URI url = UriComponentsBuilder.fromHttpUrl(movieDbEndpoint + "trending/movie/day")
                .queryParam("api_key", movieDbKey)
                .build()
                .encode()
                .toUri();
        System.out.println(url);

        MovieDbSearchedDto[] searchResponse = restTemplate.getForObject(url, MovieDbSearchedDto[].class);

        return Optional.ofNullable(searchResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public List<MovieDbSearchedDto> getMovieDbWeekTrendingList() {

        URI url = UriComponentsBuilder.fromHttpUrl(movieDbEndpoint + "trending/movie/week")
                .queryParam("api_key", movieDbKey)
                .build()
                .encode()
                .toUri();
        System.out.println(url);

        MovieDbSearchedDto[] searchResponse = restTemplate.getForObject(url, MovieDbSearchedDto[].class);

        return Optional.ofNullable(searchResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }



}
