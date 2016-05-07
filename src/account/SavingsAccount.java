package account;

import account.exceptions.InvalidAccountIdException;
import account.exceptions.InvalidBalanceException;
import account.exceptions.InvalidInterestRateException;
import account.exceptions.InvalidNumberOfMonthsException;

/**
 * Created by Radu on 5/7/16.
 */
public class SavingsAccount extends Account {
    private Integer numberOfMonths;
    private Double interestRate;

    public SavingsAccount(String accountId, Double balance, Integer numberOfMonths, Double interestRate) throws InvalidNumberOfMonthsException, InvalidInterestRateException, InvalidBalanceException, InvalidAccountIdException {
        super(accountId, balance);

        this.setNumberOfMonths(numberOfMonths);
        this.setInterestRate(interestRate);
    }

    public SavingsAccount(){

    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) throws InvalidInterestRateException {
        if ((interestRate == null) || (interestRate < 0))
            throw new InvalidInterestRateException("The interestRate cannot be null or negative");

        this.interestRate = interestRate;
    }

    public Integer getNumberOfMonths() {
        return numberOfMonths;
    }

    public void setNumberOfMonths(Integer numberOfMonths) throws InvalidNumberOfMonthsException {
        if ((numberOfMonths == null) || (numberOfMonths < 0))
            throw new InvalidNumberOfMonthsException("The numberOfMonths cannot be null or negative");

        this.numberOfMonths = numberOfMonths;
    }
}
