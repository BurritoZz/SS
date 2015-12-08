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
		array[2] = 4;
		array[3] = 3;
		polynomial = new Polynomial(array);
	}

    @Test
    public void testApply() {
        assertTrue(0 == polynomial.apply(0));
        assertTrue(10 == polynomial.apply(1));
        assertTrue(-10 == polynomial.apply(-1));
    }

    @Test
    public void testDerivative() {
        assertTrue(polynomial.derivative().toString().equals("42.0 * x^6 + 12.0 * x^2"));
    }
    
    @Test
    public void testIntegrand() {
        assertTrue(polynomial.integrand().toString().equals("0.75 * x^8 + 1.0 * x^4"));
    }
}
