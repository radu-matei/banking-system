package account;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Radu on 5/7/16.
 */
public class AccountTest {

    private static final String accountId = "accountId";
    private static final Double balance = 46.0;

    @Test
    public void getAccountId() throws Exception {
        Account account = new Account(accountId, balance);

        assertEquals(account.getAccountId(), accountId);
    }

    @Test
    public void setAccountId() throws Exception {
        Account account = new Account();
        account.setAccountId(accountId);

        assertEquals(account.getAccountId(), accountId);
    }

    @Test
    public void getBalance() throws Exception {
        Account account = new Account(accountId, balance);

        assertEquals(account.getBalance(), balance);
    }

    @Test
    public void setBalance() throws Exception {
        Account account = new Account();
        account.setBalance(balance);

        assertEquals(account.getBalance(), balance);
    }
}