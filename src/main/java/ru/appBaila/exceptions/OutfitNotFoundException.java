package ru.appBaila.exceptions;

public class OutfitNotFoundException extends RuntimeException {
    public OutfitNotFoundException(String message) {
        super(message);
    }
}
