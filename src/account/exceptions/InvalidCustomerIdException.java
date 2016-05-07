package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidCustomerIdException extends Exception {

    public InvalidCustomerIdException() {
    }

    public InvalidCustomerIdException(String message) {
        super(message);
    }
}
