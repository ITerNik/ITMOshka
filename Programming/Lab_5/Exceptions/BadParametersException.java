package Exceptions;

public class BadParametersException extends RuntimeException {
    public BadParametersException(String massage) {
        super(massage);
    }
}
