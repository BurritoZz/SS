package ss.week3.test;

import org.junit.Before;
import org.junit.Test;
import ss.week3.Multiplication;

import static org.junit.Assert.assertEquals;

public class MultiplicationTest {

    private Multiplication mul;

    @Before
    public void setUp() throws Exception {
        mul = new Multiplication();
    }

    @Test
    public void testOperate() throws Exception {
        assertEquals(0, mul.operate(0, 0));
        assertEquals(36, mul.operate(6, 6));
        assertEquals(-36, mul.operate(-6, 6));
        assertEquals(-36, mul.operate(6, -6));
        assertEquals(36, mul.operate(-6, -6));
    }

    @Test
    public void testIdentity() throws Exception {
        int identity = mul.identity();
        assertEquals(0, mul.operate(0, identity));
        assertEquals(0, mul.operate(identity, 0));
        assertEquals(36, mul.operate(36, identity));
        assertEquals(36, mul.operate(identity, 36));
        assertEquals(-36, mul.operate(-36, identity));
        assertEquals(-36, mul.operate(identity, -36));
    }
}
