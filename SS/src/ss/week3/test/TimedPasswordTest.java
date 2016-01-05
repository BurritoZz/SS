package ss.week3.test;

import org.junit.Test;
import ss.week3.pw.BasicChecker;
import ss.week3.pw.TimedPassword;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TimedPasswordTest {

    @Test
    public void test() throws Exception {
        // Create new TimedPassword that is valid for one second.
        TimedPassword tp = new TimedPassword(1);
        // Assert that it is valid.
        assertFalse("The password should not yet have expired.", tp.isExpired());
        // Sleep for 2 seconds.
        Thread.sleep(2000);
        // Assert that the password has expired.
        assertTrue("The password should have expired.", tp.isExpired());

        // Change the password
        tp.setWord(BasicChecker.INITPASS, "test123");
        // Assert that it is valid.
        assertFalse("The password should be valid after changing it and it should not yet have expired.",
                tp.isExpired());
    }
}
