package com.example.domain.exceptions;

public class HeroNotExistException extends Exception {
    private static final long serialVersionUID = -1L;

    public HeroNotExistException(final String message) {
        super(message);
    }
}
