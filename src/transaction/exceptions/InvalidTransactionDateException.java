package transaction.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidTransactionDateException extends Exception {

    public InvalidTransactionDateException() {
    }

    public InvalidTransactionDateException(String message) {
        super(message);
    }
}
