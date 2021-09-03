package com.booksmoviesapp.controller;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String message) {
        super(message);
    }
}
