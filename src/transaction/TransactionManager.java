package transaction;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Radu on 5/8/16.
 */
public class TransactionManager {

    private ConcurrentHashMap<String, Transaction> currentTransactions;
    private static TransactionManager instance = null;

    private TransactionManager(){
        currentTransactions = new ConcurrentHashMap<>();
    }

    public static TransactionManager getInstance(){
        if(instance == null)
            instance = new TransactionManager();

        return instance;
    }

    public void executeTransaction(Transaction transaction){

    }

    public void commitTransaction(String transactionId){

    }

    public void rollBackTransaction(String transactionId){

    }
}
