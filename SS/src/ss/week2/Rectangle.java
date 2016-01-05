package ss.week2;
/**
 * @author max
 * @version 1.0
 */
public class Rectangle {

	//@ private invariant length >= 0;
	//@ private invariant width >= 0;
	private int length;
	private int width;
	
	/**
	 * Constructs a rectangle using the parameters.
	 * @param length - length of the rectangle
	 * @param width - width of the rectangle
	 */
	//@ requires length >= 0;
	//@ requires width >= 0;
	//@ ensures length() == length;
	//@ ensures width() == width;
	public Rectangle(int length, int width) {
		assert width >= 0 && length >= 0;
		this.length = length;
		this.width = width;
	}
	/**
	 * Query for the length of the rectangle.
	 * @return returns the length of the rectangle
	 */
	//@ ensures \result >= 0;
	/*@pure */ public int length() {
		assert length >= 0 && width >= 0;
		return length;
	}
	/**
	 * Query for the width of the rectangle.
	 * @return returns the width of the rectangle
	 */
	//@ ensures \result >= 0;
	/*@pure */ public int width() {
		assert length >= 0 && width >= 0;
		return width;
	}
	/**
	 * Query for the area of the rectangle, calculated using width*length.
	 * @return returns the area of the rectangle
	 */
	//@ ensures \result >= 0;
	/*@pure */ public int area() {
		assert length >= 0 && width >= 0;
		return width * length;
	}
	/**
	 * Query for the perimeter of the rectangle, calculated using 2*width + 2*length.
	 * @return returns the perimeter of the rectangle
	 */
	//@ ensures \result >= 0;
	/*@pure */ public int perimeter() {
		assert length >= 0 && width >= 0;
		return 2 * width + 2 * length;
	}
}
