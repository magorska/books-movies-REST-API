package com.booksmoviesapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long bookId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "YEAR_OF_RELEASE")
    private int releaseYear;

    @Column(name = "ISBN")
    private Long isbn;

    @Column(name = "PAGES")
    private int pages;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "REVIEW_ID")
    private Review review;

}
