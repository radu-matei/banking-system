package transaction.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidTransactionIdException extends Exception {

    public InvalidTransactionIdException() {
    }

    public InvalidTransactionIdException(String message) {
        super(message);
    }
}
