package ss.week3.hotel;

import ss.week3.hotel.Bill;

/**
 * Basic implementation of Bill.Item used for testing.
 * @author max
 * @version v1.0
 */
public class BasicItem implements Bill.Item {
	
	public String text;
	public double amount;

	/**
	 * Creates a BasicItem with a text and an amount.
	 * @param text - The text used for the item.
	 * @param amount - The amount used for the item.
	 */
	public BasicItem(String text, double amount) {
		this.text = text;
		this.amount = amount;
	}
	
	/**
	 * Gets the amount of the item.
	 * @return Returns the amount of the item.
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * Gets the text of the item.
	 * @return Returns the text of the item.
	 */
	public String toString() {
		return text;
	}

}
