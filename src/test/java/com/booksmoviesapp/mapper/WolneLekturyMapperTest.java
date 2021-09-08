package com.booksmoviesapp.mapper;

import com.booksmoviesapp.domain.WolneLekturySearched;
import com.booksmoviesapp.domain.dto.WolneLekturySearchedDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WolneLekturyMapperTest {

    @Test
    void testMapToWolneLekturyDtoList() {
        //Given
        WolneLekturyMapper wolneLekturyMapper = new WolneLekturyMapper();
        WolneLekturySearched wolneLekturySearched = new WolneLekturySearched("title", "author", "kind");
        List<WolneLekturySearched> wolneLekturySearchedList = Arrays.asList(wolneLekturySearched);
        //When
        List<WolneLekturySearchedDto> wolneLekturySearchedDtoList = wolneLekturyMapper.mapToWolneLekturyDtoList(wolneLekturySearchedList);
        //Then
        assertEquals(1, wolneLekturySearchedDtoList.size());
        assertEquals("title", wolneLekturySearchedDtoList.get(0).getTitle());
        assertEquals("author", wolneLekturySearchedDtoList.get(0).getAuthor());
        assertEquals("kind", wolneLekturySearchedDtoList.get(0).getCategory());
    }

    @Test
    void testMapToWolneLekturyList() {
        //Given
        WolneLekturyMapper wolneLekturyMapper = new WolneLekturyMapper();
        WolneLekturySearchedDto wolneLekturySearchedDto = new WolneLekturySearchedDto("title", "author", "kind");
        List<WolneLekturySearchedDto> wolneLekturySearchedDtoList = Arrays.asList(wolneLekturySearchedDto);
        //When
        List<WolneLekturySearched> wolneLekturySearchedList = wolneLekturyMapper.mapToWolneLekturyList(wolneLekturySearchedDtoList);
        //Then
        assertEquals(1, wolneLekturySearchedList.size());
        assertEquals("title", wolneLekturySearchedList.get(0).getTitle());
        assertEquals("author", wolneLekturySearchedList.get(0).getAuthor());
        assertEquals("kind", wolneLekturySearchedList.get(0).getCategory());
    }

}