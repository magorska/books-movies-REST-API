package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.dto.WolneLekturySearchedDto;
import com.booksmoviesapp.wolneLektury.client.facade.WolneLekturyFacade;
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
@WebMvcTest(WolneLekturyClientController.class)
class WolneLekturyClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WolneLekturyFacade wolneLekturyFacade;

    @Test
    void shouldGetWolneLekturySearchedList() throws Exception {
        //Given
        WolneLekturySearchedDto wolneLekturySearchedDto = new WolneLekturySearchedDto("title", "author",
                "kind");

        List<WolneLekturySearchedDto> wolneLekturySearchedDtoList = Arrays.asList(wolneLekturySearchedDto);
        when(wolneLekturyFacade.searchedList()).thenReturn(wolneLekturySearchedDtoList);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/wolneLektury/allBooks"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();
    }

}