package com.booksmoviesapp.mapper;

import com.booksmoviesapp.domain.MovieDbSearched;
import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieDbMapperTest {

    @Test
    void testMapToMovieDb() {
        //Given
        MovieDbMapper movieDbMapper = new MovieDbMapper();
        MovieDbSearchedDto movieDb = new MovieDbSearchedDto(1, "title", "overview", "date", 5.5);
        //When
        MovieDbSearched mappedMovieDb = movieDbMapper.mapToMovieDb(movieDb);
        //Then
        assertEquals(1, mappedMovieDb.getId());
        assertEquals("title", mappedMovieDb.getTitle());
        assertEquals("overview", mappedMovieDb.getOverview());
        assertEquals("date", mappedMovieDb.getReleaseDate());
        assertEquals(5.5, mappedMovieDb.getVoteAverage());
    }
    @Test
    void testMapToMovieDbDto() {
        //Given
        MovieDbMapper movieDbMapper = new MovieDbMapper();
        MovieDbSearched movieDb = new MovieDbSearched(1, "title", "overview", "date", 5.5);
        //When
        MovieDbSearchedDto mappedMovieDbDto = movieDbMapper.mapToMovieDbDto(movieDb);
        //Then
        assertEquals(1, mappedMovieDbDto.getId());
        assertEquals("title", mappedMovieDbDto.getTitle());
        assertEquals("overview", mappedMovieDbDto.getOverview());
        assertEquals("date", mappedMovieDbDto.getReleaseDate());
        assertEquals(5.5, mappedMovieDbDto.getVoteAverage());
    }

    @Test
    void testMapToMovieDbDtoList() {
        //Given
        MovieDbMapper movieDbMapper = new MovieDbMapper();
        MovieDbSearched movieDb = new MovieDbSearched(1, "title", "overview", "date", 5.5);
        List<MovieDbSearched> movieDbList = Arrays.asList(movieDb);
        //When
        List<MovieDbSearchedDto> mappedMovieDbList = movieDbMapper.mapToMovieDbDtoList(movieDbList);
        //Then
        assertEquals(1, mappedMovieDbList.size());
        assertEquals(1, mappedMovieDbList.get(0).getId());
        assertEquals("title", mappedMovieDbList.get(0).getTitle());
        assertEquals("overview", mappedMovieDbList.get(0).getOverview());
        assertEquals("date", mappedMovieDbList.get(0).getReleaseDate());
        assertEquals(5.5, mappedMovieDbList.get(0).getVoteAverage());
    }

    @Test
    void testMapToMovieDbList() {
        //Given
        MovieDbMapper movieDbMapper = new MovieDbMapper();
        MovieDbSearchedDto movieDbDto = new MovieDbSearchedDto(1, "title", "overview", "date", 5.5);
        List<MovieDbSearchedDto> movieDbDtoList = Arrays.asList(movieDbDto);
        //When
        List<MovieDbSearched> mappedMovieDbList = movieDbMapper.mapToMovieDbList(movieDbDtoList);
        //Then
        assertEquals(1, mappedMovieDbList.size());
        assertEquals(1, mappedMovieDbList.get(0).getId());
        assertEquals("title", mappedMovieDbList.get(0).getTitle());
        assertEquals("overview", mappedMovieDbList.get(0).getOverview());
        assertEquals("date", mappedMovieDbList.get(0).getReleaseDate());
        assertEquals(5.5, mappedMovieDbList.get(0).getVoteAverage());
    }

}