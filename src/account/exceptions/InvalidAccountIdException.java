package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidAccountIdException extends Exception {
    public InvalidAccountIdException() {
    }

    public InvalidAccountIdException(String message) {
        super(message);
    }
}
