package account;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Radu on 5/9/16.
 */
public class TemporaryAccountStates {
    private ConcurrentHashMap<String, Account> temporaryAccountStates;

    private static TemporaryAccountStates instance = null;

    public TemporaryAccountStates() {
        temporaryAccountStates = new ConcurrentHashMap<>();
    }

    public synchronized static TemporaryAccountStates getInstance(){
        if (instance == null)
            instance = new TemporaryAccountStates();

        return instance;
    }

    public Account getAccountById(String accountId){
        return temporaryAccountStates.get(accountId);
    }

    public void addAccount(Account account){
        temporaryAccountStates.put(account.getAccountId(), account);
    }

    public void removeAccount(String accountId){
        temporaryAccountStates.remove(accountId);
    }

    public void updateAccount(Account account){
        temporaryAccountStates.put(account.getAccountId(), account);
    }
}
