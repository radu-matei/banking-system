package account;

import account.exceptions.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Radu on 5/7/16.
 */
public class TellerTest {

    private static final String tellerId = "tellerId";
    private static final String fullName = "fullName";

    @Test
    public void getTellerId() throws Exception {
        Teller teller = new Teller(tellerId, fullName);

        assertEquals(teller.getTellerId(), tellerId);
    }

    @Test
    public void setTellerId() throws Exception {
        Teller teller = new Teller();
        teller.setTellerId(tellerId);

        assertEquals(teller.getTellerId(), tellerId);
    }

    @Test
    public void getFullName() throws Exception {
        Teller teller = new Teller(tellerId, fullName);

        assertEquals(teller.getFullName(), fullName);
    }

    @Test
    public void setFullName() throws Exception {
        Teller teller = new Teller();
        teller.setFullName(fullName);

        assertEquals(teller.getFullName(), fullName);
    }

    @Test(expected = InvalidTellerId.class)
    public void setInvalidTellerId() throws InvalidTellerId, InvalidFullName {
        Teller teller = new Teller();
        teller.setTellerId(null);
    }

    @Test(expected = InvalidFullName.class)
    public void setInvalidFullName() throws InvalidFullName, InvalidTellerId {
        Teller teller = new Teller();
        teller.setFullName(null);
    }
}