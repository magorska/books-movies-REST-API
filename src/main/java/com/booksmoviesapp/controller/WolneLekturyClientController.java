package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.dto.WolneLekturySearchedDto;
import com.booksmoviesapp.wolneLektury.client.facade.WolneLekturyFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1/wolneLektury")
@RequiredArgsConstructor
public class WolneLekturyClientController {

    private final WolneLekturyFacade wolneLekturyFacade;

    @GetMapping("allBooks")
    public List<WolneLekturySearchedDto> getAllBooks() {
        return wolneLekturyFacade.searchedList();
    }
}
