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
@Table(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long movieId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "YEAR_OF_RELEASE")
    private int releaseYear;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "REVIEW_ID")
    private Review review;

    @JoinColumn(name = "CATEGORY")
    private MovieCategory category;

}
