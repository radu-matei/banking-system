package account;

import account.exceptions.*;

/**
 * Created by Radu on 5/7/16.
 */
public class Customer {
    private String customerId;

    private String fullName;
    private String address;
    private String ssn;

    private Account account;
    private Teller teller;

    public Customer(String customerId,
                    String fullName,
                    String address,
                    String ssn,
                    Account account,
                    Teller teller) throws InvalidCustomerIdException,
                                          InvalidAddressException,
                                          InvalidSsnException,
                                          InvalidAccountException,
                                          InvalidTellerException, InvalidFullName {

        this.setCustomerId(customerId);
        this.setFullName(fullName);
        this.setAddress(address);
        this.setSsn(ssn);
        this.setAccount(account);
        this.setTeller(teller);
    }

    public Customer(){

    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) throws InvalidCustomerIdException {
        if ((customerId == null) || (customerId.isEmpty()))
            throw new InvalidCustomerIdException("The accountId cannot be null or empty!");

        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws InvalidFullName {
        if ((fullName == null) || (fullName.isEmpty()))
            throw new InvalidFullName("The fullName cannot be null or empty!");

        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws InvalidAddressException {
        if ((address == null) || (address.isEmpty()))
            throw new InvalidAddressException("The accountId cannot be null or empty!");

        this.address = address;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) throws InvalidSsnException {
        if ((ssn == null) || (ssn.isEmpty()))
            throw new InvalidSsnException("The accountId cannot be null or empty!");

        this.ssn = ssn;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) throws InvalidAccountException {
        if (account == null)
            throw new InvalidAccountException("The account cannot be null!");

        this.account = account;
    }

    public Teller getTeller() {
        return teller;
    }

    public void setTeller(Teller teller) throws InvalidTellerException {
        if (teller == null)
            throw new InvalidTellerException("The accountId cannot be null or empty!");

        this.teller = teller;
    }
}
