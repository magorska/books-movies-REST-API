package com.booksmoviesapp.moviedb.client;

import com.booksmoviesapp.domain.MovieDbSearched;
import com.booksmoviesapp.domain.dto.MovieDbSearchedListDto;
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

    public List<MovieDbSearchedListDto> getMovieDbSearchList(String partOfTitle) {

        URI url = UriComponentsBuilder.fromHttpUrl(movieDbEndpoint + "search/keyword?api_key=" + movieDbKey + "&query=")
                .queryParam("api_key", movieDbKey)
                .queryParam("query", partOfTitle)
                .queryParam("pages")
                .queryParam("results", "id", "name")
                .build()
                .encode()
                .toUri();
        System.out.println(url);

        MovieDbSearchedListDto[] searchResponse = restTemplate.getForObject(url, MovieDbSearchedListDto[].class);

        return Optional.ofNullable(searchResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

//
//    public MovieDbSearched getMovieDbSearchedDetails() {
//
//        URI url = UriComponentsBuilder.fromHttpUrl(movieDbEndpoint + "/movie/" + );
//
//    }
}
