package ss.week3.hotel;

import ss.week3.hotel.Bill.Item;

public class PricedRoom extends Room implements Item {

	private double roomPrice;
	
	public PricedRoom(int no, double roomPrice, double safePrice) {
		super(no, "qwerty7", new PricedSafe(safePrice));
		this.roomPrice = roomPrice;
	}

	public double getAmount() {
		return roomPrice;
	}
	
	public String toString() {
		return "This room costs " + getAmount() + " euros per night.";
	}

}
