package org.obstacles.exceptions;

public class WrongMoveException extends RuntimeException {
    public WrongMoveException(String message) {
        super(message);
    }
}
