package com.booksmoviesapp.repository;

import com.booksmoviesapp.domain.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ReviewRepository extends CrudRepository<Review, Long> {

    @Override
    List<Review> findAll();

}
