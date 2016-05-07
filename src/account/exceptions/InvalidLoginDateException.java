package account.exceptions;

/**
 * Created by Radu on 5/7/16.
 */
public class InvalidLoginDateException extends Exception {
    public InvalidLoginDateException(){

    }

    public InvalidLoginDateException(String message){
        super(message);
    }
}
