package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidAddressException extends Exception {
    public InvalidAddressException() {
    }

    public InvalidAddressException(String message) {
        super(message);
    }
}
