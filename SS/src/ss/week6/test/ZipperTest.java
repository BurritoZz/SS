package ss.week6.test;

import org.junit.Before;
import org.junit.Test;
import ss.week6.ArgumentLengthsDifferException;
import ss.week6.TooFewArgumentsException;
import ss.week6.Zipper;

import static org.junit.Assert.assertEquals;

/**
 * Testprogram for Zipper.
 * Lab Exercise SoftwareSystems
 * @author Jip Spel
 * @version $Revision: 1.0 $
 */
public class ZipperTest {

    /** Testvariabele for a <tt>DollarsAndCentsCounter</tt> object. */
    private Zipper zipper;

    @Before
    public void setUp() {
        zipper = new Zipper();
    }

    /**
     * Test for zipping with too few arguments
     */
    @Test(expected=TooFewArgumentsException.class)
    public void testFirstArgumentNull() throws TooFewArgumentsException, ArgumentLengthsDifferException {
        zipper.zip2(null, "Hello World!");
    }

    /**
     * Test for zipping with too few arguments
     */
    @Test(expected=TooFewArgumentsException.class)
    public void testSecondArgumentNull() throws TooFewArgumentsException, ArgumentLengthsDifferException {
        zipper.zip2("Hello World!", null);
    }

    /**
     * Test for zipping with arguments of different length
     */
    @Test(expected=ArgumentLengthsDifferException.class)
    public void testDifferentArgumentLengths() throws ArgumentLengthsDifferException, TooFewArgumentsException {
        zipper.zip2("Hello World!", "Hello World");
    }

    @Test
    public void testCorrectInput() throws ArgumentLengthsDifferException, TooFewArgumentsException {
        assertEquals("HelloWorld", zipper.zip2("Hlool", "elWrd"));
    }

}
