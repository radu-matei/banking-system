package transaction.exceptions;

/**
 * Created by Radu on 5/9/16.
 */
public class InvalidTransactionException extends Exception {
    public InvalidTransactionException() {
    }

    public InvalidTransactionException(String message) {
        super(message);
    }
}
