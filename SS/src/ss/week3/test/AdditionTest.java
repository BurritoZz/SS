package ss.week3.test;

import org.junit.Before;
import org.junit.Test;
import ss.week3.Addition;

import static org.junit.Assert.assertEquals;

public class AdditionTest {

    private Addition add;

    @Before
    public void setUp() throws Exception {
        add = new Addition();
    }

    @Test
    public void testOperate() throws Exception {
        assertEquals(0, add.operate(0, 0));
        assertEquals(72, add.operate(36, 36));
        assertEquals(0, add.operate(-36, 36));
        assertEquals(0, add.operate(36, -36));
        assertEquals(-72, add.operate(-36, -36));
    }

    @Test
    public void testIdentity() throws Exception {
        int identity = add.identity();
        assertEquals(0, add.operate(0, identity));
        assertEquals(0, add.operate(identity, 0));
        assertEquals(36, add.operate(36, identity));
        assertEquals(36, add.operate(identity, 36));
        assertEquals(-36, add.operate(-36, identity));
        assertEquals(-36, add.operate(identity, -36));
    }
}
