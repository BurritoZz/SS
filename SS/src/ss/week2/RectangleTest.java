package ss.week2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Rectangle.
 * @author max
 * @version $revision 1.0 $
 */

public class RectangleTest {

	/** Testvariable for a rectangle object. */
	private Rectangle rectangle;
	
	/**
     * Sets initial variables to a well-defined initial value.
     */
    @Before
	public void setUp() {
		rectangle = new Rectangle(10, 5);
	}
    
    /**
     * Test if the initial condition complies to the specification.
     */
    @Test
    public void testInitialcondition() {
        assertEquals(10, rectangle.length());
        assertEquals(5, rectangle.width());
    }
    
    /**
     * Test if the area is calculated correctly.
     */
    @Test
    public void testArea() {
    	assertEquals(50, rectangle.area());
    }
	
    /**
     * Test if the perimeter is calculated properly.
     */
    @Test
    public void testPerimeter() {
    	assertEquals(30, rectangle.perimeter());
    }
}
