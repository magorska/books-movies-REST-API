package com.booksmoviesapp.repository;

import com.booksmoviesapp.domain.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ReviewRepository extends CrudRepository<Review, Long> {

}
