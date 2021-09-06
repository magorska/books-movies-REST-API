package com.booksmoviesapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WolneLekturySearched {

    private String title;
    private String author;
    private String category;

}
