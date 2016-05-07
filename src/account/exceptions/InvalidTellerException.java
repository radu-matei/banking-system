package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidTellerException extends Exception {
    public InvalidTellerException() {
    }

    public InvalidTellerException(String message) {
        super(message);
    }
}
