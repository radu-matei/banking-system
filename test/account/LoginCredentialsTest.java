package account;

import account.exceptions.InvalidAccessTokenException;
import account.exceptions.InvalidLoginDateException;
import account.exceptions.InvalidUserNameException;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Radu on 5/7/16.
 */
public class LoginCredentialsTest {

    private static final String userName = "userName";
    private static final String accessToken = "accessToken";
    private static final Date lastLogin = new Date();

    @Test
    public void getUserName() throws Exception {
        LoginCredentials loginCredentials = new LoginCredentials(userName, accessToken, lastLogin);

        assertEquals(loginCredentials.getUserName(), userName);
    }

    @Test
    public void setUserName() throws Exception {
        LoginCredentials loginCredentials = new LoginCredentials();
        loginCredentials.setUserName(userName);

        assertEquals(loginCredentials.getUserName(), userName);
    }

    @Test
    public void getAccessToken() throws Exception {
        LoginCredentials loginCredentials = new LoginCredentials(userName, accessToken, lastLogin);

        assertEquals(loginCredentials.getAccessToken(), accessToken);
    }

    @Test
    public void setAccessToken() throws Exception {
        LoginCredentials loginCredentials = new LoginCredentials();
        loginCredentials.setAccessToken(accessToken);

        assertEquals(loginCredentials.getAccessToken(), accessToken);
    }

    @Test
    public void getLastLogin() throws Exception {
        LoginCredentials loginCredentials = new LoginCredentials(userName, accessToken, lastLogin);

        assertEquals(loginCredentials.getLastLogin(), lastLogin);
    }

    @Test
    public void setLastLogin() throws Exception {
        LoginCredentials loginCredentials = new LoginCredentials();
        loginCredentials.setLastLogin(lastLogin);

        assertEquals(loginCredentials.getLastLogin(), lastLogin);
    }

    @Test(expected = InvalidUserNameException.class)
    public void testSetIInvalidlUserName() throws InvalidUserNameException {
        LoginCredentials loginCredentials = new LoginCredentials();

        loginCredentials.setUserName(null);
    }

    @Test(expected = InvalidAccessTokenException.class)
    public void testSetInvalidAccessToken() throws InvalidAccessTokenException {
        LoginCredentials loginCredentials = new LoginCredentials();

        loginCredentials.setAccessToken(null);
    }

    @Test(expected = InvalidLoginDateException.class)
    public void testSetInvalidLogin() throws InvalidLoginDateException {
        LoginCredentials loginCredentials = new LoginCredentials();

        loginCredentials.setLastLogin(null);
    }
}