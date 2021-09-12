package com.booksmoviesapp.wolneLektury.client;

import com.booksmoviesapp.config.WolneLekturyClientConfig;
import com.booksmoviesapp.controller.MovieDbClientController;
import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.domain.dto.WolneLekturySearchedDto;
import com.booksmoviesapp.moviedb.client.MovieDbClient;
import com.booksmoviesapp.moviedb.client.facade.MovieDbFacade;
import com.booksmoviesapp.wolneLektury.client.facade.WolneLekturyFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WolneLekturyClientTest {

    @InjectMocks
    private WolneLekturyClient wolneLekturyClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private WolneLekturyClientConfig wolneLekturyClientConfig;

    @Test
    public void testGetBooks() throws URISyntaxException {

        // Given
        when(wolneLekturyClientConfig.getWolneLekturyApiEndpoint()).thenReturn("http://test.com/");

        WolneLekturySearchedDto[] wolneLekturySearchedDto = new WolneLekturySearchedDto[1];
        wolneLekturySearchedDto[0] = new WolneLekturySearchedDto("title", "author", "kind");

        URI uri = new URI("http://test.com/books");

        when(restTemplate.getForObject(uri, WolneLekturySearchedDto[].class)).thenReturn(wolneLekturySearchedDto);

        //When
        List<WolneLekturySearchedDto> wolneLekturySearchedDtoList = wolneLekturyClient.getBooks();

        //Then
        assertEquals(1, wolneLekturySearchedDtoList.size());
        assertEquals("title", wolneLekturySearchedDtoList.get(0).getTitle());
        assertEquals("author", wolneLekturySearchedDtoList.get(0).getAuthor());
        assertEquals("kind", wolneLekturySearchedDtoList.get(0).getCategory());
    }

}