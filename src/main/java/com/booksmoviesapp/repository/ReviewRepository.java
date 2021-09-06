package com.booksmoviesapp.repository;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.domain.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Native;
import java.util.List;


@Repository
@Transactional
public interface ReviewRepository extends CrudRepository<Review, Long> {

    @Override
    List<Review> findAll();

    @Query(nativeQuery = true)
    List<Book> topThreeBooks();

    @Query(nativeQuery = true)
    List<Movie> topFiveMovies();
}
