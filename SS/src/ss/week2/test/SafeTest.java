package week2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ss.week2.hotel.Safe;

public class SafeTest {

	Safe safe;
	String password = "Wawaweewa";
	
	@Before
	public void setUp() throws Exception {
		safe = new Safe(password);
	}

	@Test
	public void testInit() {
		assertTrue(safe.getPassword().testWord(password));
		assertFalse(safe.isOpen());
		assertFalse(safe.isActive());
	}
	
	@Test
	public void testPassword() {
		safe.getPassword().acceptable("Hallo");
		safe.getPassword().setWord(password, "H a l l o");
		safe.getPassword().setWord("blablabla", password);
	}
	
	@Test
	public void testActivate() {
		safe.activate("123");
		assertFalse(safe.isOpen());
		
		safe.activate(password);
		assertTrue(safe.isActive());
	}
	
	@Test
	public void testOpen() {
		safe.open("123");
		assertFalse(safe.isOpen());
		
		safe.open(password);
		assertTrue(safe.isOpen());
	}
	
	@Test
	public void testClose() {
		safe.close();
		assertFalse(safe.isOpen());
	}
	
	@Test
	public void testDeactivate() {
		safe.deactivate();
		assertFalse(safe.isActive());
	}

}
