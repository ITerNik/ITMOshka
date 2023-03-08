package Exceptions;

public class UnexistingColorException extends RuntimeException {
    public UnexistingColorException(String message) {
        super(message);
    }
}
