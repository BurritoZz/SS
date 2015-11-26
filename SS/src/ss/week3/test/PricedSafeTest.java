package ss.week3.test;

import org.junit.Before;
import org.junit.Test;
import ss.week3.hotel.Bill;
import ss.week3.hotel.PricedSafe;

import static org.junit.Assert.*;

public class PricedSafeTest {

    private Bill.Item item;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";

    @Before
    public void setUp() throws Exception {
        item = new PricedSafe(PRICE);
    }

    @Test
    public void testGetAmount() throws Exception {
        assertEquals("GetAmount should return the price of the safe.", PRICE, item.getAmount(), 0);
    }

    @Test
    public void testToString() throws Exception {
        assertTrue("The price should be included.", item.toString().matches(PRICE_PATTERN));
    }
}
