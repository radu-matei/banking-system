package account;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Radu on 5/9/16.
 */
public class AccountRepository {
    private ConcurrentHashMap<String, Account> accounts;

    private static AccountRepository instance = null;

    public AccountRepository() {
        accounts = new ConcurrentHashMap<>();
    }

    public synchronized static AccountRepository getInstance(){
        if(instance == null)
            instance = new AccountRepository();

        return instance;
    }

    public Account getAccountById(String accountId){
        return accounts.get(accountId);
    }

    public void addAccount(Account account){
        accounts.put(account.getAccountId(), account);
    }

    public void removeAccount(String accountId){
        accounts.remove(accountId);
    }

    public void updateAccount(Account account){
        accounts.put(account.getAccountId(), account);
    }
}
