package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidAccessTokenException extends Exception {
    public InvalidAccessTokenException(){

    }

    public InvalidAccessTokenException(String message){
        super(message);
    }
}
