package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week4.math.Polynomial;

import static org.junit.Assert.assertTrue;

public class PolynomialTest {
	private Polynomial polynomial;
	private double[] array;
	
	@Before
	public void setUp()	{
		array = new double[4];
		array[0] = 6;
		array[1] = 7;
		array[2] = -4;
		array[3] = 3.2;
		polynomial = new Polynomial(array);
	}

    @Test
    public void testApply() {
        assertTrue(3.2 == polynomial.apply(0));
        assertTrue(12.2 == polynomial.apply(1));
        assertTrue(8.2 == polynomial.apply(-1));
    }

    @Test
    public void testDerivative() {
        assertTrue(polynomial.derivative().toString().equals("18.0 * x^2 + 14.0 * x^1 + -4.0 * x^0"));
    }
    
    @Test
    public void testIntegrand() {
        assertTrue(polynomial.integrand().toString().equals("1.5 * x^4 + 2.3333333333333335 * x^3 + -2.0 * x^2 + 3.2 * x^1 + 0.0 * x^0"));
    }
}
