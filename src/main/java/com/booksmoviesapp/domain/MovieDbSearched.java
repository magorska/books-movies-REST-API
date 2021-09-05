package com.booksmoviesapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MovieDbSearched {

    private Integer id;
    private String title;
    private String overview;
    private String releaseDate;
    private double voteAverage;

    @Override
    public String toString() {
        return "Title ='" + title + '\'' +
                ", \n Overview = " + overview +
                ", \n Release date = " + releaseDate +
                ", \n Vote average = " + voteAverage;
    }
}
