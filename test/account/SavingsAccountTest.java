package account;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Radu on 5/7/16.
 */
public class SavingsAccountTest {

    private static final String accountId = "accountId";
    private static final Double balance = 46.0;

    private static final Integer numberOfMonths = 12;
    private static final Double interestRate = 3.5;

    @Test
    public void getInterestRate() throws Exception {
        SavingsAccount savingsAccount = new SavingsAccount(accountId, balance, numberOfMonths, interestRate);

        assertEquals(savingsAccount.getInterestRate(), interestRate);
    }

    @Test
    public void setInterestRate() throws Exception {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setInterestRate(interestRate);

        assertEquals(savingsAccount.getInterestRate(), interestRate);
    }

    @Test
    public void getNumberOfMonths() throws Exception {
        SavingsAccount savingsAccount = new SavingsAccount(accountId, balance, numberOfMonths, interestRate);

        assertEquals(savingsAccount.getNumberOfMonths(), numberOfMonths);
    }

    @Test
    public void setNumberOfMonths() throws Exception {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setNumberOfMonths(numberOfMonths);

        assertEquals(savingsAccount.getNumberOfMonths(), numberOfMonths);
    }
}