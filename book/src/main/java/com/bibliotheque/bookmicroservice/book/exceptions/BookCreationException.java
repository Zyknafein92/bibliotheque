package com.bibliotheque.bookmicroservice.book.exceptions;

public class BookCreationException extends RuntimeException {
    public BookCreationException(String message) {
        super(message);
    }
}
