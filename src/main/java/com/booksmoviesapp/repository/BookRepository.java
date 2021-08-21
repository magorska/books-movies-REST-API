package com.booksmoviesapp.repository;

import com.booksmoviesapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Long> {

}
