package ss.week3.hotel;

import ss.week3.hotel.Bill.Item;

public class PricedSafe extends Safe implements Item{

	private String text = "Priced Safe";
	private double amount;
	
	public PricedSafe(String password, double amount) {
		super(password);
		this.amount = amount;
	}
	
	public PricedSafe(double amount) {
		super("qwerty7");
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public String toString() {
		return text + " which costs " + amount;
	}
	
}
