package transaction;

import account.Account;
import account.exceptions.*;

import org.junit.Test;

import transaction.exceptions.*;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Radu on 5/7/16.
 */
public class TransferTransactionTest {

    private static final String transactionId = "transactionId";
    private static final Date transactionDate = new Date();
    protected Double transactionAmount = 46.0;

    private static Account targetAccount = null;

    static {
        try {
            targetAccount = new Account("targetAccountId", 47.0);
        } catch (InvalidAccountIdException | InvalidBalanceException e) {
            e.printStackTrace();
        }
    }

    private static Account destinationAccount;

    static {
        try {
            destinationAccount = new Account("destinationAccountId", 30.0);
        } catch (InvalidAccountIdException | InvalidBalanceException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void setTargetAccount() throws InvalidAccountException {
        TransferTransaction transferTransaction = new TransferTransaction();
        transferTransaction.setTargetAccount(targetAccount);

        assertEquals(transferTransaction.getTargetAccount(), targetAccount);
    }

    @Test
    public void setDestinationAccount() throws InvalidAccountException {
        TransferTransaction transferTransaction = new TransferTransaction();
        transferTransaction.setDestinationAccount(destinationAccount);

        assertEquals(transferTransaction.getDestinationAccount(), destinationAccount);
    }


    @Test
    public void setTransactionId() throws InvalidTransactionIdException {
        TransferTransaction transferTransaction = new TransferTransaction();
        transferTransaction.setTransactionId(transactionId);

        assertEquals(transferTransaction.getTransactionId(), transactionId);
    }

    @Test
    public void setTransactionDate() throws InvalidTransactionDateException {
        TransferTransaction transferTransaction = new TransferTransaction();
        transferTransaction.setTransactionDate(transactionDate);

        assertEquals(transferTransaction.getTransactionDate(), transactionDate);
    }

    @Test
    public void setTransactionAmount() throws InvalidTransactionAmountException {
        TransferTransaction transferTransaction = new TransferTransaction();
        transferTransaction.setTransactionAmount(transactionAmount);

        assertEquals(transferTransaction.getTransactionAmount(), transactionAmount);
    }

    @Test
    public void execute() throws Exception {
        TransferTransaction transferTransaction = new TransferTransaction(transactionId,
                                                                          transactionDate,
                                                                          transactionAmount,
                                                                          targetAccount,
                                                                          destinationAccount);
        transferTransaction.execute();

        assertEquals(targetAccount.getBalance(), new Double(1.0));
        assertEquals(destinationAccount.getBalance(), new Double(76.0));
    }

    @Test(expected = InvalidTransactionAmountException.class)
    public void executeInvalidAmount() throws Exception {
        TransferTransaction transferTransaction = new TransferTransaction(transactionId,
                                                                          transactionDate,
                                                                          null,
                                                                          targetAccount,
                                                                          destinationAccount);

        transferTransaction.execute();
    }

    @Test(expected = InvalidAccountException.class)
    public void executeInvalidTargetAccount() throws Exception{
        TransferTransaction transferTransaction = new TransferTransaction(transactionId,
                                                                          transactionDate,
                                                                          transactionAmount,
                                                                          null,
                                                                          destinationAccount);
        transferTransaction.execute();
    }

    @Test(expected = InvalidAccountException.class)
    public void executeInvalidDestinationAccount() throws Exception{
        TransferTransaction transferTransaction = new TransferTransaction(transactionId,
                                                                          transactionDate,
                                                                          transactionAmount,
                                                                          targetAccount,
                                                                          null);
        transferTransaction.execute();
    }

    @Test(expected = InvalidTransactionAmountException.class)
    public void executeInvalidTransactionAmount() throws Exception{
        TransferTransaction transferTransaction = new TransferTransaction(transactionId,
                                                                          transactionDate,
                                                                          48.0,
                                                                          targetAccount,
                                                                          destinationAccount);
        transferTransaction.execute();
    }
}