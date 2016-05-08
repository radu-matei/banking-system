package transaction;

import account.Account;

import account.exceptions.*;
import transaction.exceptions.*;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Radu on 5/8/16.
 */
public class WithdrawTransactionTest {


    protected static final String transactionId = "transactionId";
    protected static final Date transactionDate = new Date();
    private static final Double transactionAmount = 2.0;

    private static Account targetAccount;

    static {
        try {
            targetAccount = new Account("accountId", 4.0);
        } catch (InvalidAccountIdException | InvalidBalanceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void execute() throws Exception {
        WithdrawTransaction withdrawTransaction = new WithdrawTransaction(transactionId,
                                                                          transactionDate,
                                                                          transactionAmount,
                                                                          targetAccount);

        Double targetBalance = targetAccount.getBalance();

        withdrawTransaction.execute();

        assertEquals(targetAccount.getBalance(), new Double(targetBalance - transactionAmount));
    }

    @Test(expected = InvalidAccountException.class)
    public void executeInvalidTargetAccount() throws Exception {
        WithdrawTransaction withdrawTransaction = new WithdrawTransaction(transactionId,
                                                                          transactionDate,
                                                                          transactionAmount,
                                                                          null);

        withdrawTransaction.execute();
    }

    @Test(expected = InvalidTransactionAmountException.class)
    public void executeInvalidTransferAmount() throws Exception {
        WithdrawTransaction withdrawTransaction = new WithdrawTransaction(transactionId,
                                                                          transactionDate,
                                                                          new Double(0),
                                                                          targetAccount);

        withdrawTransaction.execute();
    }
}