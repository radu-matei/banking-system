package account;

import account.exceptions.InvalidAccessTokenException;
import account.exceptions.InvalidLoginDateException;
import account.exceptions.InvalidUserNameException;

import java.util.Date;

/**
 * Created by Radu on 5/7/16.
 */
public class LoginCredentials {
    private String userName;
    private String accessToken;
    private Date lastLogin;

    public LoginCredentials(String userName, String accessToken, Date lastLogin) throws InvalidUserNameException, InvalidAccessTokenException, InvalidLoginDateException {
        this.setUserName(userName);
        this.setAccessToken(accessToken);
        this.setLastLogin(lastLogin);
    }

    public LoginCredentials(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws InvalidUserNameException {
        if ((userName == null) || (userName.isEmpty()))
            throw new InvalidUserNameException("The userName cannot be null or empty!");

        this.userName = userName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) throws InvalidAccessTokenException {
        if ((accessToken == null) || (accessToken.isEmpty()))
            throw new InvalidAccessTokenException("The accessToken cannot be null or empty!");

        this.accessToken = accessToken;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) throws InvalidLoginDateException {
        if (lastLogin == null)
            throw new InvalidLoginDateException("The userName cannot be null!");

        this.lastLogin = lastLogin;
    }
}
