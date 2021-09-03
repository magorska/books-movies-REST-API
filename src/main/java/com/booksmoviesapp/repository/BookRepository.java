package com.booksmoviesapp.repository;

import com.booksmoviesapp.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BookRepository extends CrudRepository <Book, Long> {

    @Override
    List<Book> findAll();
}
