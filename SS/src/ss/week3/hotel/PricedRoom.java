package ss.week3.hotel;

import ss.week3.hotel.Bill.Item;

public class PricedRoom extends Room implements Item {

	private double roomPrice;
	private double safePrice;
	
	public PricedRoom(int no, double roomPrice, double safePrice) {
		super(no, "qwerty7", new PricedSafe(safePrice));
		this.roomPrice = roomPrice;
		this.safePrice = safePrice;
	}

	public double getAmount() {
		return roomPrice + safePrice;
	}
	
	public String toString() {
		return "This room costs " + getAmount() + " euros per night.";
	}

}
