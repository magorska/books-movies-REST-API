package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.dto.WolneLekturySearchedDto;
import com.booksmoviesapp.wolneLektury.client.WolneLekturyClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/wolneLektury")
@RequiredArgsConstructor
public class WolneLekturyClientController {

    private final WolneLekturyClient wolneLekturyClient;

    @GetMapping("allBooks")
    public void getAllBooks() {

        List<WolneLekturySearchedDto> searchedList = wolneLekturyClient.getBooks();

        searchedList.forEach(searchList -> {
            System.out.println(searchList.getTitle() + "\n" + searchList.getAuthor() +
                    "\n" + searchList.getCategory());
        });
    }
}
