package com.booksmoviesapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MOVIE_DB")
public class MovieDbEntity {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "OVERVIEW")
    private String overview;

    @Column(name = "RELEASE_YEAR")
    private String releaseYear;

    @Column(name = "VOTE_AVERAGE")
    private double voteAverage;

}
