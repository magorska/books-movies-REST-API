package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.moviedb.client.facade.MovieDbFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(MovieDbClientController.class)
class MovieDbClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieDbFacade movieDbFacade;

    @Test
    void shouldGetMovieDbSearchedList() throws Exception {
        //Given
        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto(1, "title",
                "overview", "date", 5.5);

        List<MovieDbSearchedDto> movieDbSearchedDtoList = Arrays.asList(movieDbSearchedDto);
        String keyword = "lord";
        when(movieDbFacade.searchedList(keyword)).thenReturn(movieDbSearchedDtoList);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/movieDb/searchList"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void shouldGetMovieDbLatest() throws Exception {
        //Given
        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto(1, "title",
                "overview", "date", 5.5);

        when(movieDbFacade.getLatest()).thenReturn(movieDbSearchedDto);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/movieDb/latest"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void shouldGetMovieDbUpComing() throws Exception {
        //Given
        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto(1, "title",
                "overview", "date", 5.5);

        List<MovieDbSearchedDto> movieDbSearchedDtoList = Arrays.asList(movieDbSearchedDto);
        when(movieDbFacade.getUpComing()).thenReturn(movieDbSearchedDtoList);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/movieDb/upcoming"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void shouldGetMovieDbTopRated() throws Exception {
        //Given
        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto(1, "title",
                "overview", "date", 5.5);

        List<MovieDbSearchedDto> movieDbSearchedDtoList = Arrays.asList(movieDbSearchedDto);
        when(movieDbFacade.getTopRated()).thenReturn(movieDbSearchedDtoList);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/movieDb/topRated"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void shouldGetMovieDbDayTrending() throws Exception {
        //Given
        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto(1, "title",
                "overview", "date", 5.5);

        List<MovieDbSearchedDto> movieDbSearchedDtoList = Arrays.asList(movieDbSearchedDto);
        when(movieDbFacade.getDayTrending()).thenReturn(movieDbSearchedDtoList);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/movieDb/dayTrending"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void shouldGetMovieDbWeekTrending() throws Exception {
        //Given
        MovieDbSearchedDto movieDbSearchedDto = new MovieDbSearchedDto(1, "title",
                "overview", "date", 5.5);

        List<MovieDbSearchedDto> movieDbSearchedDtoList = Arrays.asList(movieDbSearchedDto);
        when(movieDbFacade.getWeekTrending()).thenReturn(movieDbSearchedDtoList);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/movieDb/weekTrending"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();
    }
}