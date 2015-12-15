package ss.week6.test;

import org.junit.Before;
import org.junit.Test;
import ss.week6.dictionaryattack.DictionaryAttack;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Testprogram for DictionaryAttack.
 * Lab Exercise SoftwareSystems
 * @author Jip Spel
 * @version $Revision: 1.0 $
 */
public class DictionaryAttackTest {

    /** Testvariabele for a <tt>DictionaryAttack</tt> object. */
    private DictionaryAttack dictionaryAttack;

    /** Path to the text file */
    private static final String PATH = ""; //Your path to the test folder

    @Before
    public void setUp() {
        dictionaryAttack = new DictionaryAttack();
        try {
            dictionaryAttack.readPasswords(PATH + "LeakedPasswords.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test for <tt>getPasswordHash</tt>
     */
    @Test
    public void testGetPasswordHash() {
        assertEquals("5f4dcc3b5aa765d61d8327deb882cf99", dictionaryAttack.getPasswordHash("password"));
    }

    /**
     * Test for <tt>checkPassword</tt>
     */
    @Test
    public void testCheckPassword() {
        assertTrue(dictionaryAttack.checkPassword("katrine", "spongebob"));
    }

}
