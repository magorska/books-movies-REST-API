package com.booksmoviesapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private Long categoryId;

    @Column(name = "CATEGORY")
    private String categoryName;

    @OneToMany(
    targetEntity = Book.class,
    mappedBy = "bookId",
    fetch = FetchType.LAZY
    )
    private List<Book> booksCategory;

    @OneToMany(
            targetEntity = Movie.class,
            mappedBy = "movieId",
            fetch =  FetchType.LAZY
    )
    private List<Movie> moviesCategory;
}
