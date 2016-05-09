package transaction;

import account.Account;
import account.AccountRepository;
import transaction.exceptions.InvalidTransactionException;
import utils.Debugger;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Radu on 5/8/16.
 */
public class TransactionManager {

    private ConcurrentHashMap<String, Transaction> currentTransactions;
    private TransactionRepository transactionRepository;

    private ConcurrentHashMap<String, Account> currentAccounts;
    private AccountRepository accountRepository;

    private static TransactionManager instance = null;

    private TransactionManager(){
        currentTransactions = new ConcurrentHashMap<>();
        transactionRepository = TransactionRepository.getInstance();

        currentAccounts = new ConcurrentHashMap<>();
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
            currentAccounts.put(account.getAccountId(), account);
        }

        transaction.execute();

        Debugger.log(String.format("Transaction executed. Number of current transactions:% d",
                                    currentTransactions.size()));
    }

    public void commitTransaction(String transactionId) throws Exception {
        if ((!currentTransactions.containsKey(transactionId)) || (transactionId == null))
            throw new InvalidTransactionException("The transaction was not found or the id is invalid");

        Transaction transaction = currentTransactions.get(transactionId);

        for (Account account: transaction.getAccounts()) {
            accountRepository.updateAccount(account);
            currentAccounts.remove(account.getAccountId());
        }

        transactionRepository.updateTransaction(transaction);
        currentTransactions.remove(transactionId);
    }

    public void rollBackTransaction(String transactionId) throws Exception {

        if ((!currentTransactions.contains(transactionId)) || (transactionId == null))
            throw new InvalidTransactionException("The transaction was not found or the id is invalid");

        currentTransactions.remove(transactionId);

        Transaction transaction = currentTransactions.get(transactionId);

        for (Account account: transaction.getAccounts()) {
            accountRepository.put(account.getAccountId(), account);
            currentAccounts.remove(account.getAccountId());
        }
    }
}
