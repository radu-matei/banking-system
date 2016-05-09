import account.*;

import transaction.*;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        TransactionManager transactionManager = TransactionManager.getInstance();
        TransactionRepository transactionRepository = TransactionRepository.getInstance();

        AccountRepository accountRepository = AccountRepository.getInstance();

        Account targetAccount = new Account("targetAccountId", 4.0);
        accountRepository.addAccount(targetAccount);

        DepositTransaction depositTransaction = new DepositTransaction("depositTransaction",
                                                                        new Date(),
                                                                        46.0,
                                                                        targetAccount);
        transactionRepository.addTransaction(depositTransaction);

        transactionManager.executeTransaction(depositTransaction);
        transactionManager.commitTransaction(depositTransaction.getTransactionId());
    }
}
