package transaction.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidTransactionAmountException extends Exception {
    public InvalidTransactionAmountException() {
    }

    public InvalidTransactionAmountException(String message) {
        super(message);
    }
}
