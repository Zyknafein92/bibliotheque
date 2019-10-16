package com.bibliotheque.usermicroservice.exceptions;

public class UserCreationException extends RuntimeException {

    public UserCreationException(String message) {
        super(message);
    }
}
