package account;

import account.exceptions.InvalidFullName;
import account.exceptions.InvalidTellerId;

/**
 * Created by Radu on 5/7/16.
 */
public class Teller {
    private String tellerId;
    private String fullName;

    public Teller(String tellerId, String fullName) throws InvalidTellerId, InvalidFullName {
        this.setTellerId(tellerId);
        this.setFullName(fullName);
    }

    public Teller(){

    }

    public String getTellerId() {
        return tellerId;
    }

    public void setTellerId(String tellerId) throws InvalidTellerId {
        if ((tellerId == null) || (tellerId.isEmpty()))
            throw new InvalidTellerId("The tellerId cannot be null or empty!");

        this.tellerId = tellerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws InvalidFullName {
        if ((fullName == null) || (fullName.isEmpty()))
            throw new InvalidFullName("The fullName cannot be null or empty!");
        this.fullName = fullName;
    }
}
