package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidFullName extends Exception {

    public InvalidFullName() {
    }

    public InvalidFullName(String message) {
        super(message);
    }
}
