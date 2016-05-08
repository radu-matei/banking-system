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
public class DepositTransactionTest {
    private static final String transactionId = "transactionId";
    private static final Date transactionDate = new Date();
    private static final Double transactionAmount = 46.0;

    private static Account targetAccount;

    static {
        try {
            targetAccount = new Account("accountId", 4.0);
        } catch (InvalidAccountIdException | InvalidBalanceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setTargetAccount() throws Exception {
        DepositTransaction depositTransaction = new DepositTransaction();
        depositTransaction.setTargetAccount(targetAccount);

        assertEquals(depositTransaction.getTargetAccount(), targetAccount);
    }

    @Test
    public void execute() throws Exception {
        DepositTransaction depositTransaction = new DepositTransaction(transactionId,
                                                                       transactionDate,
                                                                       transactionAmount,
                                                                       targetAccount);
        Double targetBalance = targetAccount.getBalance();

        depositTransaction.execute();

        assertEquals(targetAccount.getBalance(), new Double(targetBalance + transactionAmount));
    }

    @Test(expected = InvalidAccountException.class)
    public void executeInvalidTargetAccount() throws Exception {
        DepositTransaction depositTransaction = new DepositTransaction(transactionId,
                                                                       transactionDate,
                                                                       transactionAmount,
                                                                       null);

        depositTransaction.execute();
    }

    @Test(expected = InvalidTransactionAmountException.class)
    public void executeInvalidTransferAmount() throws Exception {
        DepositTransaction depositTransaction = new DepositTransaction(transactionId,
                                                                       transactionDate,
                                                                       new Double(0),
                                                                       targetAccount);

        depositTransaction.execute();
    }
}