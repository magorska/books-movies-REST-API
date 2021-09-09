package com.booksmoviesapp.moviedb.client;

import com.booksmoviesapp.config.MovieDbClientConfig;
import com.booksmoviesapp.domain.MovieDbSearched;
import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import org.junit.jupiter.api.Test;
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

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private MovieDbClientConfig movieDbClientConfig;

    @Test
    public void testGetSearchedList() throws URISyntaxException {
        // Given
        when(movieDbClientConfig.getMovieDbApiEndpoint()).thenReturn("http://test.com/");
        when(movieDbClientConfig.getApiKey()).thenReturn("test");

        MovieDbSearchedDto[] movieDbSearchedDto = new MovieDbSearchedDto[1];
        movieDbSearchedDto[0] = new MovieDbSearchedDto(1, "title", "overview",
                "date", 5.5);

        URI uri = new URI("http://test.com/search/movie?api_key=test&query=lord");

        when(restTemplate.getForObject(uri, MovieDbSearchedDto[].class)).thenReturn(movieDbSearchedDto);

        //When
        String keyword = "lord";
        List<MovieDbSearchedDto> testSearchedList = movieDbClient.getMovieDbSearchList(keyword);

        //Then
        assertEquals(1, testSearchedList.size());
        assertEquals(1, testSearchedList.get(0).getId());
        assertEquals("title", testSearchedList.get(0).getTitle());
        assertEquals("overview", testSearchedList.get(0).getOverview());
        assertEquals("date", testSearchedList.get(0).getReleaseDate());
        assertEquals(5.5, testSearchedList.get(0).getVoteAverage());
    }

    @Test
    public void testGetLatestMovie() throws URISyntaxException {
        // Given
        when(movieDbClientConfig.getMovieDbApiEndpoint()).thenReturn("http://test.com/");
        when(movieDbClientConfig.getApiKey()).thenReturn("test");

        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto(1, "title",
                "overview", "date", 5.5);

        URI uri = new URI("http://test.com/movie/latest?api_key=test");

        when(restTemplate.getForObject(uri, MovieDbSearchedDto.class)).thenReturn(movieDbSearchedDto);

        //When
        MovieDbSearchedDto testSearched = movieDbClient.getMovieDbLatest();

        //Then
        assertEquals(1, testSearched.getId());
        assertEquals("title", testSearched.getTitle());
        assertEquals("overview", testSearched.getOverview());
        assertEquals("date", testSearched.getReleaseDate());
        assertEquals(5.5, testSearched.getVoteAverage());
    }

    @Test
    public void testGetUpComing() throws URISyntaxException {
        // Given
        when(movieDbClientConfig.getMovieDbApiEndpoint()).thenReturn("http://test.com/");
        when(movieDbClientConfig.getApiKey()).thenReturn("test");

        MovieDbSearchedDto[] movieDbSearchedDto = new MovieDbSearchedDto[1];
        movieDbSearchedDto[0] = new MovieDbSearchedDto(1, "title", "overview",
                "date", 5.5);

        URI uri = new URI("http://test.com/movie/upcoming?api_key=test");

        when(restTemplate.getForObject(uri, MovieDbSearchedDto[].class)).thenReturn(movieDbSearchedDto);

        //When
        List<MovieDbSearchedDto> testUpComingList = movieDbClient.getMovieDbUpComingList();

        //Then
        assertEquals(1, testUpComingList.size());
        assertEquals(1, testUpComingList.get(0).getId());
        assertEquals("title", testUpComingList.get(0).getTitle());
        assertEquals("overview", testUpComingList.get(0).getOverview());
        assertEquals("date", testUpComingList.get(0).getReleaseDate());
        assertEquals(5.5, testUpComingList.get(0).getVoteAverage());
    }

    @Test
    public void testGetTopRated() throws URISyntaxException {
        // Given
        when(movieDbClientConfig.getMovieDbApiEndpoint()).thenReturn("http://test.com/");
        when(movieDbClientConfig.getApiKey()).thenReturn("test");

        MovieDbSearchedDto[] movieDbSearchedDto = new MovieDbSearchedDto[1];
        movieDbSearchedDto[0] = new MovieDbSearchedDto(1, "title", "overview",
                "date", 5.5);

        URI uri = new URI("http://test.com/movie/top_rated?api_key=test");

        when(restTemplate.getForObject(uri, MovieDbSearchedDto[].class)).thenReturn(movieDbSearchedDto);

        //When
        List<MovieDbSearchedDto> testTopRatedList = movieDbClient.getMovieDbTopRatedList();

        //Then
        assertEquals(1, testTopRatedList.size());
        assertEquals(1, testTopRatedList.get(0).getId());
        assertEquals("title", testTopRatedList.get(0).getTitle());
        assertEquals("overview", testTopRatedList.get(0).getOverview());
        assertEquals("date", testTopRatedList.get(0).getReleaseDate());
        assertEquals(5.5, testTopRatedList.get(0).getVoteAverage());
    }

    @Test
    public void testGetDayTrending() throws URISyntaxException {
        // Given
        when(movieDbClientConfig.getMovieDbApiEndpoint()).thenReturn("http://test.com/");
        when(movieDbClientConfig.getApiKey()).thenReturn("test");

        MovieDbSearchedDto[] movieDbSearchedDto = new MovieDbSearchedDto[1];
        movieDbSearchedDto[0] = new MovieDbSearchedDto(1, "title", "overview",
                "date", 5.5);

        URI uri = new URI("http://test.com/trending/movie/day?api_key=test");

        when(restTemplate.getForObject(uri, MovieDbSearchedDto[].class)).thenReturn(movieDbSearchedDto);

        //When
        List<MovieDbSearchedDto> testDayTrendingList = movieDbClient.getMovieDbDayTrendingList();

        //Then
        assertEquals(1, testDayTrendingList.size());
        assertEquals(1, testDayTrendingList.get(0).getId());
        assertEquals("title", testDayTrendingList.get(0).getTitle());
        assertEquals("overview", testDayTrendingList.get(0).getOverview());
        assertEquals("date", testDayTrendingList.get(0).getReleaseDate());
        assertEquals(5.5, testDayTrendingList.get(0).getVoteAverage());
    }

    @Test
    public void testGetWeekTrending() throws URISyntaxException {
        // Given
        when(movieDbClientConfig.getMovieDbApiEndpoint()).thenReturn("http://test.com/");
        when(movieDbClientConfig.getApiKey()).thenReturn("test");

        MovieDbSearchedDto[] movieDbSearchedDto = new MovieDbSearchedDto[1];
        movieDbSearchedDto[0] = new MovieDbSearchedDto(1, "title", "overview",
                "date", 5.5);

        URI uri = new URI("http://test.com/trending/movie/week?api_key=test");

        when(restTemplate.getForObject(uri, MovieDbSearchedDto[].class)).thenReturn(movieDbSearchedDto);

        //When
        List<MovieDbSearchedDto> testWeekTrendingList = movieDbClient.getMovieDbWeekTrendingList();

        //Then
        assertEquals(1, testWeekTrendingList.size());
        assertEquals(1, testWeekTrendingList.get(0).getId());
        assertEquals("title", testWeekTrendingList.get(0).getTitle());
        assertEquals("overview", testWeekTrendingList.get(0).getOverview());
        assertEquals("date", testWeekTrendingList.get(0).getReleaseDate());
        assertEquals(5.5, testWeekTrendingList.get(0).getVoteAverage());
    }

}