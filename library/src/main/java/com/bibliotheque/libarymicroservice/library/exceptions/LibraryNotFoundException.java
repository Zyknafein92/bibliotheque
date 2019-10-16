package com.bibliotheque.libarymicroservice.library.exceptions;

public class LibraryNotFoundException extends RuntimeException {

    public LibraryNotFoundException(String message) {
        super(message);
    }
}
