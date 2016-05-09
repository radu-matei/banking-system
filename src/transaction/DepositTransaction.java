package transaction;

import account.Account;

import account.exceptions.*;
import transaction.exceptions.*;

import java.util.Date;

/**
 * Created by Radu on 5/8/16.
 */
public class DepositTransaction extends Transaction {

    private Account targetAccount;

    public DepositTransaction(String transactionId,
                              Date transactionDate,
                              Double transactionAmount,
                              Account targetAccount) throws InvalidTransactionDateException,
                                                            InvalidTransactionIdException,
                                                            InvalidTransactionAmountException,
                                                            InvalidAccountException {
        super(transactionId, transactionDate, transactionAmount);

        this.setTargetAccount(targetAccount);
    }

    public DepositTransaction(){

    }

    public void setTargetAccount(Account targetAccount) throws InvalidAccountException {
        if (targetAccount == null)
            throw new InvalidAccountException("The target account cannot be null!");

        this.targetAccount = targetAccount;
        this.accounts.add(0, targetAccount);
    }

    public Account getTargetAccount(){
        return targetAccount;
    }

    @Override
    public void execute() throws Exception {
        if(targetAccount == null)
            throw new InvalidAccountException("The target account cannot be null!");

        if ((transactionAmount == null) || (transactionAmount <= 0))
            throw new InvalidTransactionAmountException("The deposited transaction cannot be null, empty or negative");

        targetAccount.setBalance(targetAccount.getBalance() + transactionAmount);
    }
}
