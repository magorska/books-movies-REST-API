package com.booksmoviesapp.service;

import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.moviedb.client.MovieDbClient;
import com.booksmoviesapp.scheduler.MovieDbScheduler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieDbClientServiceTest {

    @InjectMocks
    private MovieDbClientService movieDbClientService;

    @Mock
    private MovieDbClient movieDbClient;

    @Mock
    private MovieDbScheduler movieDbScheduler;

    @Test
    void shouldGetSearchedList() {
        //Given
        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto();
        String keyword = "lord";
        List<MovieDbSearchedDto> movieDbSearchedDtoList = Arrays.asList(movieDbSearchedDto);
        when(movieDbClient.getMovieDbSearchList(keyword)).thenReturn(movieDbSearchedDtoList);

        //When
        List<MovieDbSearchedDto> testMovieDbSearchedDtoList = movieDbClientService.searchedList(keyword);

        //Then
        assertEquals(1, testMovieDbSearchedDtoList.size());
    }

    @Test
    void shouldGetLatestMovie() {
        //Given
        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto(1, "title", "overview", "date", 5.5);
        when(movieDbClient.getMovieDbLatest()).thenReturn(movieDbSearchedDto);

        //When
        MovieDbSearchedDto testMovieDbSearchedDto = movieDbClientService.latestMovie();

        //Then
        assertEquals(1, testMovieDbSearchedDto.getId());
        assertEquals("title", testMovieDbSearchedDto.getTitle());
        assertEquals("overview", testMovieDbSearchedDto.getOverview());
        assertEquals("date", testMovieDbSearchedDto.getReleaseDate());
        assertEquals(5.5, testMovieDbSearchedDto.getVoteAverage());
    }

//    @Test
//    void shouldGetUpcomingMovies() {
//        //Given
//        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto();
//        List<MovieDbSearchedDto> movieDbSearchedDtoList = Arrays.asList(movieDbSearchedDto);
//        when(movieDbClient.getMovieDbUpComingList()).thenReturn(movieDbSearchedDtoList);
//
//        //When
//        List<MovieDbSearchedDto> testMovieDbSearchedDtoList = movieDbScheduler.saveUpComing();
//
//        //Then
//        assertEquals(0, testMovieDbSearchedDtoList.size());
//    }

//    @Test
//    void testGetTopRated() {
//        //Given
//        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto();
//        List<MovieDbSearchedDto> movieDbSearchedDtoList = Arrays.asList(movieDbSearchedDto);
//        when(movieDbClient.getMovieDbTopRatedList()).thenReturn(movieDbSearchedDtoList);
//
//        //When
//        List<MovieDbSearchedDto> testMovieDbSearchedDtoList = movieDbClientService.topRated();
//
//        //Then
//        assertEquals(1, testMovieDbSearchedDtoList.size());
//    }
//
//    @Test
//    void testGetDayTrending() {
//        //Given
//        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto();
//        List<MovieDbSearchedDto> movieDbSearchedDtoList = Arrays.asList(movieDbSearchedDto);
//        when(movieDbClient.getMovieDbDayTrendingList()).thenReturn(movieDbSearchedDtoList);
//
//        //When
//        List<MovieDbSearchedDto> testMovieDbSearchedDtoList = movieDbClientService.dayTrending();
//
//        //Then
//        assertEquals(1, testMovieDbSearchedDtoList.size());
//    }
//
//    @Test
//    void testGetWeekTrending() {
//        //Given
//        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto();
//        List<MovieDbSearchedDto> movieDbSearchedDtoList = Arrays.asList(movieDbSearchedDto);
//        when(movieDbClient.getMovieDbWeekTrendingList()).thenReturn(movieDbSearchedDtoList);
//
//        //When
//        List<MovieDbSearchedDto> testMovieDbSearchedDtoList = movieDbClientService.weekTrending();
//
//        //Then
//        assertEquals(1, testMovieDbSearchedDtoList.size());
//    }

}