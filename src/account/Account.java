package account;

import account.exceptions.InvalidAccountIdException;
import account.exceptions.InvalidBalanceException;

/**
 * Created by Radu on 5/7/16.
 */
public class Account {
    private String accountId;
    private Double balance;

    public Account(String accountId, Double balance) throws InvalidAccountIdException, InvalidBalanceException {
        this.setAccountId(accountId);
        this.setBalance(balance);
    }

    public Account(){

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) throws InvalidAccountIdException {
        if((accountId == null) || (accountId.isEmpty()))
            throw new InvalidAccountIdException("The accountId cannot be null or empty!");

        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) throws InvalidBalanceException {
        if((balance == null) || (balance.isInfinite()))
            throw new InvalidBalanceException("The accountId cannot be null or empty!");

        this.balance = balance;
    }
}
