package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Review;
import com.booksmoviesapp.domain.dto.BookDto;
import com.booksmoviesapp.mapper.BookMapper;
import com.booksmoviesapp.service.BookDbService;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringJUnitWebConfig
@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookDbService bookDbService;

    @MockBean
    private BookMapper bookMapper;


    @Test
    void shouldGetBooks() throws Exception {
        //Given
        BookDto bookDto = new BookDto(1L, "title", "author", 2020, 1L, 20, new Review());
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(bookDto);

        when(bookMapper.mapToBookDtoList(anyList())).thenReturn(bookDtoList);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/books/allBooks"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void shouldGetBook() throws Exception {
        //Given
        BookDto bookDto = new BookDto(1L, "title", "author", 2020, 1L, 20, new Review());
        Book book = new Book(1L, "title", "author", 2020, 1L, 20, new Review());

        when(bookMapper.mapToBookDto(book)).thenReturn(bookDto);
        when(bookDbService.getBook(1L)).thenReturn(Optional.of(book));

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/books/1"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.bookId", is(1)));
    }

    @Test
    public void shouldDeleteBook() throws Exception {
        //Given
        Book book = new Book(1L, "title", "author", 2020, 1L, 20, new Review());

        when(bookDbService.getBook(1L)).thenReturn(Optional.of(book));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/books/1"))
                .andExpect(status().is(200));
    }

    @Test
    void shouldUpdateBook() throws Exception {
        Book book = new Book(1L, "title", "author", 2020, 1L, 20, new Review());
        BookDto bookDto = new BookDto(1L, "title", "author", 2020, 1L, 20, new Review());
        when(bookMapper.mapToBook(bookDto)).thenReturn(book);
        when(bookMapper.mapToBookDto(book)).thenReturn(bookDto);
        when(bookDbService.saveBook(book)).thenReturn(book);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(status().is(200));
    }

    @Test
    void shouldCreateBook() throws Exception {
        // Given
        BookDto bookDto = new BookDto(1L, "title", "author", 2020, 1L, 20, new Review());
        Book book = new Book(1L, "title", "author", 2020, 1L, 20, new Review());

        when(bookMapper.mapToBook(bookDto)).thenReturn(book);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/books")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());

        verify(bookDbService, times(1)).saveBook(book);
    }

}