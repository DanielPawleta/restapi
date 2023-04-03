package dpawleta.restapi.exceptions;

public class IllegalJsonBodyException extends RuntimeException {
    public IllegalJsonBodyException(String message) {
        super(message);
    }
}
