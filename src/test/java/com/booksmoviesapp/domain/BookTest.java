package com.booksmoviesapp.domain;

import com.booksmoviesapp.repository.BookRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//class BookTest {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Test
//    public void BookDaoSave() {
//        //Given
//        Book book = new Book(1L, "title", "author", 2020, 1L, 20, new Review(), new Category());
//        //When
//        bookRepository.save(book);
//        Long id = book.getBookId();
//        //Then
//        assertEquals(1L, id);
//        //Clean up
//        bookRepository.deleteById(id);
//    }
//
//}