package ss.week3.hotel;
import ss.week3.hotel.Bill.Item;

public class pricedSafe extends Safe implements Item {
	private double prijs;

	public pricedSafe(String password, double prijs) {
		super(password);
		this.prijs = prijs;
	}
	public pricedSafe(double prijs)	{
		super("qwert7");
		this.prijs = prijs;
	}

	@Override
	public double getAmount() {
		return prijs;
	}
	public String toString()	{
		return "Kluis ter waarde van " + prijs;
	}

}
