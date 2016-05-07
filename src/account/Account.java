package account;

/**
 * Created by Radu on 5/7/16.
 */
public class Account {
    private String accountId;
    private Double balance;

    public Account(String accountId, Double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public Account(){

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
