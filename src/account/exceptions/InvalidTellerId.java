package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidTellerId extends Exception {
    public InvalidTellerId() {
    }

    public InvalidTellerId(String message) {
        super(message);
    }
}
