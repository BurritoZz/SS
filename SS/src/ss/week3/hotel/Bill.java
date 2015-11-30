package ss.week3.hotel;

import ss.week3.Format.Format;

/**
 * The bill of a room.
 * @author max
 * @version v1.0
 */
public class Bill {

	private java.io.PrintStream theOutStream;
	private double sum;
	
	/**
	 * Abstractions of the items on the bill.
	 * Every item has an amount and description; the description is available with toString().
	 * @author max
	 * @version v1.0
	 */
	public static interface Item {
		public double getAmount();
		public String toString();
	}
	
	/**
	 * Constructs a Bill sending the output to a given PrintStream.
	 * @param theOutStream - The output stream, or null if you don't want output.
	 */
	public Bill(java.io.PrintStream theOutStream) {
		this.theOutStream = theOutStream;
		sum = 0;
	}
	
	/**
	 * Print the sum of the bill on the output stream.
	 */
	public void close() {
		if (theOutStream != null) {
			theOutStream.println(Format.printLine("Het totaal is: ", sum));
		}
	}
	
	/**
	 * Return the sum of the bill.
	 * @return returns the sum of the bill.
	 */
	public double getSum() {
		return sum;
	}
	
	/**
	 * Add an item to the bill.
	 * @param item - The item to be added to the bill.
	 */
	public void newItem(Bill.Item item) {
		if (theOutStream != null) {
			theOutStream.println(Format.printLine(item.toString(), item.getAmount()));
		}
		sum += item.getAmount();
	}
	
	
	
}
