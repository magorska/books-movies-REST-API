package com.booksmoviesapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MovieDbSearched {

    private Integer id;
    private String title;
    private String overview;
    private String release_date;
    private double voteAverage;

    @Override
    public String toString() {
        return "Title ='" + title + '\'' +
                ", \n Overview = " + overview +
                ", \n Release date = " + release_date +
                ", \n Vote average = " + voteAverage;
    }
}
