package com.example.demo.exceptions;

public class CharacterNotFoundException extends RuntimeException{

    public CharacterNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CharacterNotFoundException() {
    }

}
