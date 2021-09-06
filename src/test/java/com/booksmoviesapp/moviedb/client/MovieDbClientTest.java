package com.booksmoviesapp.moviedb.client;

import com.booksmoviesapp.config.MovieDbClientConfig;
import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieDbClientTest {

    @InjectMocks
    private MovieDbClient movieDbClient;

    @InjectMocks
    private RestTemplate restTemplate;

    @Mock
    private MovieDbClientConfig clientConfig;

    @Test
    public void shouldGetSearchedList() throws URISyntaxException {
        //Given
        when(clientConfig.getMovieDbApiEndpoint()).thenReturn("http://test.com");
        when(clientConfig.getApiKey()).thenReturn("test");
        MovieDbSearchedDto[] movieDbSearched = new MovieDbSearchedDto[1];
        movieDbSearched[0] = new MovieDbSearchedDto(1, "title", "test", "date", 5.5);

        URI uri = new URI("http://test.com/search/movie?test&query=title");

        when(restTemplate.getForObject(uri, MovieDbSearchedDto[].class)).thenReturn(movieDbSearched);

        //When
        List<MovieDbSearchedDto> searchedMovieDbList = movieDbClient.getMovieDbSearchList("title");

        //Then
        assertEquals(1, searchedMovieDbList.size());
    }

    @Test
    void shouldMovieDbSearcherReturnEmptyList() throws URISyntaxException {

        //Given
        when(clientConfig.getMovieDbApiEndpoint()).thenReturn("http://test.com");
        when(clientConfig.getApiKey()).thenReturn("test");
        MovieDbSearchedDto[] movieDbSearched = null;
        URI uri = new URI("http://test.com/search/movie?test&query=title");
        when(restTemplate.getForObject(uri, MovieDbSearchedDto[].class)).thenReturn(movieDbSearched);

        //When
        List<MovieDbSearchedDto> resultMovieDbSearchedList = movieDbClient.getMovieDbSearchList("title");

        //Then
        assertEquals(0, resultMovieDbSearchedList.size());
    }

//    @Test
//    public void shouldGetMovieDbLatest() throws URISyntaxException {
//        // Given
//        when(clientConfig.getMovieDbApiEndpoint()).thenReturn("http://test.com");
//        when(clientConfig.getMovieDbApiEndpoint()).thenReturn("test");
//        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto(
//                1, "title", "test", "date", 5.5
//        );
//        URI uri = new URI("http://test.com/search/latest?test");
//
//        when(restTemplate.postForObject(uri, null, MovieDbSearchedDto.class)).thenReturn(movieDbSearchedDto);
//        // When
//        MovieDbSearchedDto resultLatest = movieDbClient.getMovieDbLatest();
//
//        // Then
//        assertEquals("1", newCard.getId());
//        assertEquals("test task", newCard.getName());
//        assertEquals("http://test.com", newCard.getShortUrl());
//    }

}