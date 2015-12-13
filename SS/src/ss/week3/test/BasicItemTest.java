package ss.week3.test;

import ss.week3.hotel.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BasicItemTest {
	private Bill bon;
//	private java.io.PrintStream lijst;
	
	@Before
	public void setUp()	{
		bon = new Bill(null);
	}
    
    @Test
    public void testClose() throws Exception	{
    	bon.close();
    }
    
    @Test
    public void testSum() throws Exception	{
    	bon.newItem(new BasicItem("now for somethingcompletely different", 6.66));
    	final double som = 6.66;
    	assertTrue(bon.getSum() == som);
    }
}