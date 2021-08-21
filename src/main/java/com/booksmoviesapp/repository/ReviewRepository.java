package com.booksmoviesapp.repository;

import com.booksmoviesapp.domain.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}
