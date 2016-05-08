package transaction;

import transaction.exceptions.*;
import java.util.Date;

/**
 * Created by Radu on 5/7/16.
 */
public abstract class Transaction {
    protected String transactionId;
    protected Date transactionDate;
    protected Double transactionAmount;

    public Transaction(String transactionId,
                       Date transactionDate,
                       Double transactionAmount) throws InvalidTransactionAmountException,
                                                        InvalidTransactionDateException,
                                                        InvalidTransactionIdException {
        this.setTransactionId(transactionId);
        this.setTransactionDate(transactionDate);
        this.setTransactionAmount(transactionAmount);
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

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) throws InvalidTransactionAmountException {
        if ((transactionAmount == null) || (transactionAmount < 0))
            throw new InvalidTransactionAmountException("The amount cannot be null or negative!");

        this.transactionAmount = transactionAmount;
    }

    public abstract void execute() throws Exception;
}
