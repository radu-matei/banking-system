package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidInterestRateException extends Exception {
    public InvalidInterestRateException() {
    }

    public InvalidInterestRateException(String message) {
        super(message);
    }
}
