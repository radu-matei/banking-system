package account;

import java.util.Date;

/**
 * Created by Radu on 5/7/16.
 */
public class LoginCredentials {
    private String userName;
    private String accessToken;
    private Date lastLogin;

    public LoginCredentials(String userName, String accessToken, Date lastLogin) {
        this.userName = userName;
        this.accessToken = accessToken;
        this.lastLogin = lastLogin;
    }

    public LoginCredentials(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
