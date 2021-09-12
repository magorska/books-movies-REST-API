package com.booksmoviesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.booksmoviesapp.*")
@SpringBootApplication
public class BooksMoviesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksMoviesAppApplication.class, args);
	}

}
