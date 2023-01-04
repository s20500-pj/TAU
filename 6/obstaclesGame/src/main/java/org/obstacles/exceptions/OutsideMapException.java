package org.obstacles.exceptions;

public class OutsideMapException extends RuntimeException {
    public OutsideMapException(String message) {
        super(message);
    }
}
