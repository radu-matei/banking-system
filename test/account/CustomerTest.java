package account;

import account.exceptions.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Radu on 5/7/16.
 */
public class CustomerTest {

    private static final String customerId = "customerId";

    private static final String fullName = "fullName";
    private static final String address = "address";
    private static final String ssn = "ssn";

    private static Account account = null;

    static {
        try {
            account = new Account("accountId", 46.0);
        } catch (InvalidAccountIdException | InvalidBalanceException e) {
            e.printStackTrace();
        }
    }

    private static Teller teller = null;

    static {
        try {
            teller = new Teller("tellerId", "tellerName");
        } catch (InvalidTellerId | InvalidFullName e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCustomerId() throws Exception {
        Customer customer = new Customer(customerId, fullName, address, ssn, account, teller);

        assertEquals(customer.getCustomerId(), customerId);
    }

    @Test
    public void setCustomerId() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);

        assertEquals(customer.getCustomerId(), customerId);
    }

    @Test
    public void getFullName() throws Exception {
        Customer customer = new Customer(customerId, fullName, address, ssn, account, teller);

        assertEquals(customer.getFullName(), fullName);
    }

    @Test
    public void setFullName() throws Exception {
        Customer customer = new Customer();
        customer.setFullName(fullName);

        assertEquals(customer.getFullName(), fullName);
    }

    @Test
    public void getAddress() throws Exception {
        Customer customer = new Customer(customerId, fullName, address, ssn, account, teller);

        assertEquals(customer.getAddress(), address);
    }

    @Test
    public void setAddress() throws Exception {
        Customer customer = new Customer();
        customer.setAddress(address);

        assertEquals(customer.getAddress(), address);
    }

    @Test
    public void getSsn() throws Exception {
        Customer customer = new Customer(customerId, fullName, address, ssn, account, teller);

        assertEquals(customer.getSsn(), ssn);
    }

    @Test
    public void setSsn() throws Exception {
        Customer customer = new Customer();
        customer.setSsn(ssn);

        assertEquals(customer.getSsn(), ssn);
    }

    @Test
    public void getAccount() throws Exception {
        Customer customer = new Customer(customerId, fullName, address, ssn, account, teller);

        assertEquals(customer.getAccount(), account);
    }

    @Test
    public void setAccount() throws Exception {
        Customer customer = new Customer();
        customer.setAccount(account);

        assertEquals(customer.getAccount(), account);
    }

    @Test
    public void getTeller() throws Exception {
        Customer customer = new Customer(customerId, fullName, address, ssn, account, teller);

        assertEquals(customer.getTeller(), teller);
    }

    @Test
    public void setTeller() throws Exception {
        Customer customer = new Customer();
        customer.setTeller(teller);

        assertEquals(customer.getTeller(), teller);
    }
}