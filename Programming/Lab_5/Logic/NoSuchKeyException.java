package Logic;

public class NoSuchKeyException extends RuntimeException {
    public NoSuchKeyException(String message) {
        super(message);
    }
}