package com.booksmoviesapp.wolneLektury.client.facade;

import com.booksmoviesapp.domain.WolneLekturySearched;
import com.booksmoviesapp.domain.dto.WolneLekturySearchedDto;
import com.booksmoviesapp.mapper.WolneLekturyMapper;
import com.booksmoviesapp.wolneLektury.client.WolneLekturyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WolneLekturyFacade {

    @Autowired
    private WolneLekturyClient wolneLekturyClient;

    @Autowired
    private WolneLekturyMapper wolneLekturyMapper;

    public List<WolneLekturySearchedDto> searchedList() {
        List<WolneLekturySearched> searchedBooks = wolneLekturyMapper.mapToWolneLekturyList(wolneLekturyClient.getBooks());
        List<WolneLekturySearched> resultList = new ArrayList<>(searchedBooks);
        return wolneLekturyMapper.mapToWolneLekturyDtoList(resultList);
    }
}
