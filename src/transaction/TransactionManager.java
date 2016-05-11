package transaction;

import account.Account;
import account.AccountRepository;
import account.TemporaryAccountStates;
import transaction.exceptions.InvalidTransactionException;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Radu on 5/8/16.
 */
public class TransactionManager {

    private ConcurrentHashMap<String, Transaction> currentTransactions;
    private TransactionRepository transactionRepository;

    private TemporaryAccountStates currentAccounts;
    private AccountRepository accountRepository;

    private static TransactionManager instance = null;

    private TransactionManager(){
        currentTransactions = new ConcurrentHashMap<>();
        transactionRepository = TransactionRepository.getInstance();

        currentAccounts = TemporaryAccountStates.getInstance();
        accountRepository = AccountRepository.getInstance();
    }

    public synchronized static TransactionManager getInstance(){
        if(instance == null)
            instance = new TransactionManager();

        return instance;
    }

    public void executeTransaction(Transaction transaction) throws Exception {
        if (currentTransactions.contains(transaction.getTransactionId()))
            throw new InvalidTransactionException("This transaction is currently executing!");

        currentTransactions.put(transaction.getTransactionId(), transaction);

        for (Account account: transaction.getAccounts()) {
            currentAccounts.addAccount(account);
        }

        transaction.execute();
    }

    public void commitTransaction(String transactionId) throws Exception {
        if ((!currentTransactions.containsKey(transactionId)) || (transactionId == null))
            throw new InvalidTransactionException("The transaction was not found or the id is invalid");

        Transaction transaction = currentTransactions.get(transactionId);

        for (Account account: transaction.getAccounts()) {
            accountRepository.updateAccount(account);
            currentAccounts.removeAccount(account.getAccountId());
        }

        transactionRepository.updateTransaction(transaction);
        currentTransactions.remove(transactionId);
    }

    public void rollBackTransaction(String transactionId) throws Exception {

        if ((!currentTransactions.containsKey(transactionId)) || (transactionId == null))
            throw new InvalidTransactionException("The transaction was not found or the id is invalid");

        Transaction transaction = currentTransactions.get(transactionId);

        for (Account account: transaction.getAccounts()) {
            accountRepository.updateAccount(account);
            currentAccounts.removeAccount(account.getAccountId());
        }

        currentTransactions.remove(transactionId);
    }
}
