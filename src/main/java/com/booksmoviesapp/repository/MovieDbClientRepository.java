package com.booksmoviesapp.repository;

import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.moviedb.client.MovieDbClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDbClientRepository extends CrudRepository<MovieDbClient, Long> {

    List<MovieDbSearchedDto> saveAll(List<MovieDbSearchedDto> entities);

}
