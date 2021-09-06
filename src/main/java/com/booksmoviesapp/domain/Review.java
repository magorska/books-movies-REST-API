package com.booksmoviesapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@NamedNativeQueries({
//        @NamedNativeQuery(
//                name = "Books.topThreeBooks",
//                query = "SELECT TITLE, AUTHOR FROM BOOKS" +
//                        " LEFT JOIN REVIEWS ON BOOKS.ID = REVIEWS.BOOKS_ID" +
//                        " ORDER BY rating DESC " +
//                        " LIMIT 3",
//                resultClass = Book.class
//        ),
//        @NamedNativeQuery(
//                name = "Movies.topFiveMovies",
//                query = "SELECT title, director FROM MOVIES" +
//                        " LEFT JOIN REVIEWS ON MOVIES.ID = REVIEWS.MOVIES_ID" +
//                        " ORDER BY rating DESC " +
//                        " LIMIT 5",
//                resultClass = Movie.class
//        )
//})

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REVIEWS")
public class Review {

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
