package com.example.demo.exceptions;

public class CharactersIdMismatchException extends RuntimeException {

    public CharactersIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public CharactersIdMismatchException() {
    }
}
