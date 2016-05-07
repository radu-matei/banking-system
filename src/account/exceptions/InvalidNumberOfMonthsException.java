package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidNumberOfMonthsException extends Exception {
    public InvalidNumberOfMonthsException() {
    }

    public InvalidNumberOfMonthsException(String message) {
        super(message);
    }
}
