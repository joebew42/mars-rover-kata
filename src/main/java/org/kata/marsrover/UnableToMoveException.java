package org.kata.marsrover;

public class UnableToMoveException extends RuntimeException {
    public UnableToMoveException(String message) {
        super(message);
    }
}
