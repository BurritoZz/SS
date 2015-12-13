package ss.week4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolynomialTest {

	public Polynomial poly1;
	public double[] testArray1;

	@Before
	public void setUp() throws Exception {
		testArray1 = new double[6];
		testArray1[0] = 1;
		testArray1[1] = 2;
		testArray1[2] = 3;
		testArray1[3] = 4;
		testArray1[4] = 5;
		testArray1[5] = 6;
		poly1 = new Polynomial(testArray1);
	}

	@Test
	public void testApply() {
		assertTrue(21 == poly1.apply(1));
	}
	
	@Test
	public void testDerivative() {
		System.out.println(poly1.derivative().apply(1));
	}

	/*@Test
	public void testDerivative() {
		Function deriv = poly1.derivative();
		System.out.println(deriv.apply(1));
		assertTrue(35 == deriv.apply(1));
	}*/
// 1*x^5 + 2*x^4 + 3*x^3 + 4*x^2 + 5*x^1 + 6
// 1 5 x4 2 4 x3 3 3 x2 4 2 x 5
// 5 + 8 + 9 + 8 + 5 = 35
}
