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
@Table(name = "REVIEWS")
public class Review {

    @NamedQueries({
            @NamedQuery(
                    name = "Book.topThreeBooks",
                    query = "FROM Book JOIN Review ON Book.id = Review.id"
                            + "ORDER BY rating DESC LIMIT 3"
            ),
            @NamedQuery(
                    name = "Movie.topFiveMovies",
                    query = "FROM movies" +
                            "JOIN reviews" +
                            "ON Movie.id = reviews.id" +
                            "ORDER BY rating DESC" +
                            "LIMIT 5"
            )
    })


    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long reviewId;

    @NotNull
    @Column(name = "RATING")
    private int rating;

    @Column(name = "REVIEW")
    private String review;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOKS_ID")
    private Book book;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MOVIES_ID")
    private Movie movie;

}
