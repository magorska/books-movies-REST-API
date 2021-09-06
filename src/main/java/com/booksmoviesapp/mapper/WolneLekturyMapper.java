package com.booksmoviesapp.mapper;

import com.booksmoviesapp.domain.WolneLekturySearched;
import com.booksmoviesapp.domain.dto.WolneLekturySearchedDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WolneLekturyMapper {

    public List<WolneLekturySearchedDto> mapToWolneLekturyDtoList(final List<WolneLekturySearched> wolneLekturySearched) {
        return wolneLekturySearched.stream()
                .map(books -> new WolneLekturySearchedDto(
                        books.getTitle(), books.getAuthor(), books.getCategory()
                ))
                .collect(Collectors.toList());
    }

    public List<WolneLekturySearched> mapToWolneLekturyList(final List<WolneLekturySearchedDto> wolneLekturySearchedDto) {
        return wolneLekturySearchedDto.stream()
                .map(books -> new WolneLekturySearched(
                        books.getTitle(), books.getAuthor(), books.getCategory()
                ))
                .collect(Collectors.toList());
    }
}
