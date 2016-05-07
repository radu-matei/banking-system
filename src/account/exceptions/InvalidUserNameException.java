package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidUserNameException extends Exception {
    public InvalidUserNameException(){

    }

    public InvalidUserNameException(String message){
        super(message);
    }
}
