package ss.week3.hotel;

public class BasicItem implements Bill.Item	{
	private String beschrijving;
	private double bedrag;

	public BasicItem(String text, double amount)	{
		beschrijving = text;
		bedrag = amount;
	}

	public String toString() {
		return beschrijving;
	}

	public double getAmount() {
		return bedrag;
	}

}
