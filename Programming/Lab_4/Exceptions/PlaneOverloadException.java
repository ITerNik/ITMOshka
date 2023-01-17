package Exceptions;

public class PlaneOverloadException extends RuntimeException {
    PlaneOverloadException(String message) {
        super(message);
    }
}
