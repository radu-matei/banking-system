package transaction;

import account.Account;

import account.exceptions.*;
import transaction.exceptions.*;

/**
 * Created by Radu on 5/7/16.
 */
public class TransferTransaction extends Transaction {

    private Account targetAccount;
    private Account destinationAccount;

    public TransferTransaction(Account targetAccount, Account destinationAccount) throws InvalidAccountException {
        this.setTargetAccount(targetAccount);
        this.setDestinationAccount(destinationAccount);
    }

    public TransferTransaction(){

    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(Account targetAccount) throws InvalidAccountException {
        if (targetAccount == null)
            throw new InvalidAccountException("The target account cannot be null!");

        this.targetAccount = targetAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) throws InvalidAccountException {
        if (destinationAccount== null)
            throw new InvalidAccountException("The destination account cannot be null!");

        this.destinationAccount = destinationAccount;
    }

    @Override
    public void execute() throws InvalidAccountException, InvalidTransactionAmountException {
        if ((targetAccount == null) || (destinationAccount == null))
            throw new InvalidAccountException("The target or destination account cannot be null or empty!");

        if (targetAccount.getBalance() < this.amount)
            throw new InvalidTransactionAmountException("The balance of the targetAccount cannot be " +
                                                        "less than the amount of the transaction!");

        try {
            targetAccount.setBalance(targetAccount.getBalance() - this.amount);
        } catch (InvalidBalanceException e) {
            e.printStackTrace();
        }

        try {
            destinationAccount.setBalance(destinationAccount.getBalance() + this.amount);
        } catch (InvalidBalanceException e) {
            e.printStackTrace();
        }
    }
}
