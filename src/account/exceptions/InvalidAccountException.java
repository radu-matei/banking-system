package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidAccountException extends Exception {

    public InvalidAccountException() {
    }

    public InvalidAccountException(String message) {
        super(message);
    }
}
