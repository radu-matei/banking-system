package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidSsnException extends Exception {

    public InvalidSsnException() {
    }

    public InvalidSsnException(String message) {
        super(message);
    }
}
