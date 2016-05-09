package transaction;

import account.Account;
import account.AccountRepository;

import account.TemporaryAccountStates;
import account.exceptions.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Radu on 5/9/16.
 */
public class TransactionManagerTest {

    private static final TransactionManager transactionManager = TransactionManager.getInstance();
    private static final AccountRepository accountRepository = AccountRepository.getInstance();
    private static final TemporaryAccountStates currentAccounts = TemporaryAccountStates.getInstance();

    private static Account targetAccount = null;
    private static Account destinationAccount = null;

    @Before
    public void initialize(){
        try {
            targetAccount = new Account("targetAccountId", 47.0);
        } catch (InvalidAccountIdException | InvalidBalanceException e) {
            e.printStackTrace();
        }

        try {
            destinationAccount = new Account("destinationAccountId", 30.0);
        } catch (InvalidAccountIdException | InvalidBalanceException e) {
            e.printStackTrace();
        }

        accountRepository.addAccount(targetAccount);
        accountRepository.addAccount(destinationAccount);
    }

    @Test
    public void executeTransaction() throws Exception {

        TransferTransaction transferTransaction = new TransferTransaction("transactionId",
                                                                          new Date(),
                                                                          new Double(17.0),
                                                                          targetAccount,
                                                                          destinationAccount);
        transactionManager.executeTransaction(transferTransaction);

        assertEquals(targetAccount.getBalance(), new Double(30.0));
        assertEquals(destinationAccount.getBalance(), new Double(47.0));

        assertEquals(targetAccount, currentAccounts.getAccountById(targetAccount.getAccountId()));
        assertEquals(destinationAccount, currentAccounts.getAccountById(destinationAccount.getAccountId()));
    }

    @Test
    public void commitTransaction() throws Exception {
        TransferTransaction transferTransaction = new TransferTransaction("transactionId",
                                                                          new Date(),
                                                                          new Double(17.0),
                                                                            targetAccount,
                                                                            destinationAccount);

        transactionManager.executeTransaction(transferTransaction);
        transactionManager.commitTransaction(transferTransaction.getTransactionId());


        assertEquals(targetAccount, accountRepository.getAccountById(targetAccount.getAccountId()));
        assertEquals(destinationAccount, accountRepository.getAccountById(destinationAccount.getAccountId()));

    }

    @Test
    public void rollBackTransaction() throws Exception {
        TransferTransaction transferTransaction = new TransferTransaction("transactionId",
                                                                          new Date(),
                                                                          new Double(17.0),
                                                                          targetAccount,
                                                                          destinationAccount);
        transactionManager.executeTransaction(transferTransaction);
        transactionManager.rollBackTransaction(transferTransaction.getTransactionId());


        assertEquals(targetAccount, accountRepository.getAccountById(targetAccount.getAccountId()));
        assertEquals(destinationAccount, accountRepository.getAccountById(destinationAccount.getAccountId()));
    }
}