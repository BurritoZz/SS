package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week4.math.Constant;
import ss.week4.math.LinearProduct;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinearProductTest {

    private static final double DELTA = 1e-15;
    private static final double CONSTANT_VALUE = Math.PI;
    private LinearProduct linearProduct;

    @Before
    public void setUp() {
        linearProduct = new LinearProduct(new Constant(CONSTANT_VALUE), new Constant(CONSTANT_VALUE));
    }

    @Test
    public void testApply() {
        assertEquals(CONSTANT_VALUE * CONSTANT_VALUE, linearProduct.apply(0), DELTA);
        assertEquals(CONSTANT_VALUE * CONSTANT_VALUE, linearProduct.apply(-1), DELTA);
        assertEquals(CONSTANT_VALUE * CONSTANT_VALUE, linearProduct.apply(1), DELTA);
    }

    @Test
    public void testDerivative() {
        assertTrue(linearProduct.derivative() instanceof LinearProduct);
        assertEquals(0.0, linearProduct.derivative().apply(0), DELTA);
    }
}
