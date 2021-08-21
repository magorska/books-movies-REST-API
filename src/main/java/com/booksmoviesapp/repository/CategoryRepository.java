package com.booksmoviesapp.repository;

import com.booksmoviesapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
