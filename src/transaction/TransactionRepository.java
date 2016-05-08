package transaction;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Radu on 5/9/16.
 */
public class TransactionRepository {
    private ConcurrentHashMap<String, Transaction> transactions;

    private static TransactionRepository instance = null;


    private TransactionRepository() {
        transactions = new ConcurrentHashMap<>();
    }

    public synchronized static TransactionRepository getInstance() {
        if(instance == null)
            instance = new TransactionRepository();

        return instance;
    }

    public Transaction getTransactionById(String transactionId) {
        return transactions.get(transactionId);
    }

    public void addTransaction(Transaction transaction) {
        transactions.put(transaction.getTransactionId(), transaction);
    }
    public void removeTransaction(String transactionId) {
        transactions.remove(transactionId);
    }

    public void updateTransaction(Transaction transaction){
        transactions.put(transaction.getTransactionId(), transaction);
    }
}
