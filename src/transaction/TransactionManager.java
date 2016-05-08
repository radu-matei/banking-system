package transaction;

import transaction.exceptions.InvalidTransactionException;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Radu on 5/8/16.
 */
public class TransactionManager {

    private ConcurrentHashMap<String, Transaction> currentTransactions;
    private TransactionRepository transactionRepository;

    private static TransactionManager instance = null;

    private TransactionManager(){
        currentTransactions = new ConcurrentHashMap<>();
        transactionRepository = TransactionRepository.getInstance();
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

        transaction.execute();
    }

    public void commitTransaction(String transactionId) throws Exception {
        if ((!currentTransactions.contains(transactionId)) || (transactionId == null))
            throw new InvalidTransactionException("The transaction was not found or the id is invalid");

        Transaction transaction = currentTransactions.get(transactionId);

        transactionRepository.updateTransaction(transaction);
        currentTransactions.remove(transactionId);
    }

    public void rollBackTransaction(String transactionId) throws Exception {

        if ((!currentTransactions.contains(transactionId)) || (transactionId == null))
            throw new InvalidTransactionException("The transaction was not found or the id is invalid");

        currentTransactions.remove(transactionId);
    }
}
