package com.booksmoviesapp.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDbSearchedListDto {

    @JsonProperty("pages")
    private Integer pages;

    @JsonProperty("results")
    private List<MovieDbSearchedDto> movieList;



}
