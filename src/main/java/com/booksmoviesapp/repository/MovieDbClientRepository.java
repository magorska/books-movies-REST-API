package com.booksmoviesapp.repository;

import com.booksmoviesapp.domain.MovieDbEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieDbClientRepository extends CrudRepository<MovieDbEntity, Long> {

}
