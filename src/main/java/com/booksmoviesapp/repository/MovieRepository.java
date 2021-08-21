package com.booksmoviesapp.repository;

import com.booksmoviesapp.domain.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository <Movie, Long> {

}
