package transaction;

import transaction.exceptions.*;
import java.util.Date;

/**
 * Created by Radu on 5/7/16.
 */
public abstract class Transaction {
    protected String transactionId;
    protected Date transactionDate;
    protected Double amount;

    public Transaction(String transactionId,
                       Date transactionDate,
                       Double amount) throws InvalidTransactionAmountException,
                                             InvalidTransactionDateException,
                                             InvalidTransactionIdException {
        this.setTransactionId(transactionId);
        this.setTransactionDate(transactionDate);
        this.setAmount(amount);
    }

    public Transaction(){

    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) throws InvalidTransactionIdException {
        if ((transactionId == null) || (transactionId.isEmpty()))
            throw new InvalidTransactionIdException("The transactionId cannot be null");

        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) throws InvalidTransactionDateException {
        if (transactionDate == null)
            throw new InvalidTransactionDateException("The transaction date cannot be null");

        this.transactionDate = transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) throws InvalidTransactionAmountException {
        if ((amount == null) || (amount < 0))
            throw new InvalidTransactionAmountException("The amount cannot be null or negative!");

        this.amount = amount;
    }

    public abstract void execute() throws Exception;
}
