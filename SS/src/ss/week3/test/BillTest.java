package ss.week3.test;

import org.junit.Before;
import org.junit.Test;
import ss.week3.hotel.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BillTest {

	Bill bill;
	BasicItem item1;
	BasicItem item2;
	
	@Before
	public void setUp() throws Exception {
		bill = new Bill(null);
		item1 = new BasicItem("hallo", 1.0);
		item2 = new BasicItem("doei", 2.7);
		
	}

	@Test
	public void test() {
		assertTrue(0 == bill.getSum());
		bill.newItem(item1);
		assertTrue(1.0 == bill.getSum());
		bill.newItem(item2);
		assertTrue(3.7 == bill.getSum());
		bill.close();
		assertTrue(1.0 == item1.getAmount());
		assertTrue(2.7 == item2.getAmount());
		assertTrue("hallo".equals(item1.toString()));
		assertTrue("doei".equals(item2.toString()));
	}

}
