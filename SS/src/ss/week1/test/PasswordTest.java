package ss.week1.test;

import org.junit.Before;
import org.junit.Test;
import ss.week1.Password;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Testprogram Password.
 * Lab exercise Softwaresystems
 * @author Arend Rensink, Jip Spel
 * @version $Revision: 1.2 $
 */
public class PasswordTest {
	/** Testvariabele for a <tt>Password</tt> object. */
	private Password pass;

	/**
	 * Sets the instance variable <tt>pass</tt> to a well-defined initial value.
	 */
	@Before
	public void setUp() {
		pass = new Password();
	}

	/**
	 * Test the method <tt>acceptable(suggestion)</tt>
	 */
    @Test
	public void testAcceptable() {
		assertFalse(pass.acceptable("no"));
		assertFalse(pass.acceptable("no nono"));
        assertFalse(pass.acceptable("no no"));
		assertTrue(pass.acceptable("yesyesyes"));
	}

    /**
	 * Test the method <tt>testWord</tt>
	 */
    @Test
	public void testTestWord() {
		assertFalse(pass.testWord("wrong"));
		assertTrue(pass.testWord(new String(Password.INITIAL)));
	}

	/**
	 * Test the method <tt>setWord</tt> with a wrong old password.
	 */
    @Test
	public void testSetWordWrongOld() {
		String wrongOldPassowrd = "wrongwrong";
		String newPassword = "yesyesyes";
		assertFalse(pass.setWord(wrongOldPassowrd, newPassword));
		assertTrue(pass.testWord(Password.INITIAL));
		assertFalse(pass.testWord(newPassword));
	}

	/**
	 * Test the method <tt>setWord</tt> with an unacceptable new password.
	 */
    @Test
	public void testSetWordWrongNew() {
		String wrongNew = "no no";
		assertFalse(pass.setWord(Password.INITIAL, wrongNew));
		assertTrue(pass.testWord(Password.INITIAL));
		assertFalse(pass.testWord(wrongNew));
	}

	/**
	 * Test the method <tt>setWord</tt> for correct usage.
	 */
    @Test
	public void testSetWordOkay() {
		String newpass = "yesyesyes";
		assertTrue(pass.setWord(Password.INITIAL, newpass));
		assertFalse(pass.testWord(Password.INITIAL));
		assertTrue(pass.testWord(newpass));
	}
}
