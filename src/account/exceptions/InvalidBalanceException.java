package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidBalanceException extends Exception {
    public InvalidBalanceException() {
    }

    public InvalidBalanceException(String message) {
        super(message);
    }
}
