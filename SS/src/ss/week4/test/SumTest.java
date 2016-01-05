package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week4.math.Constant;
import ss.week4.math.Sum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SumTest {

    private static final double DELTA = 1e-15;
    private static final double CONSTANT_VALUE = Math.PI;
    private Sum sum;

    @Before
    public void setUp() {
        sum = new Sum(new Constant(CONSTANT_VALUE), new Constant(CONSTANT_VALUE));
    }

    @Test
    public void testApply() {
        assertEquals(CONSTANT_VALUE + CONSTANT_VALUE, sum.apply(0), DELTA);
        assertEquals(CONSTANT_VALUE + CONSTANT_VALUE, sum.apply(-1), DELTA);
        assertEquals(CONSTANT_VALUE + CONSTANT_VALUE, sum.apply(1), DELTA);
    }

    @Test
    public void testDerivative() {
        assertTrue(sum.derivative() instanceof Sum);
        assertEquals(0.0, sum.derivative().apply(0), DELTA);
    }
}
