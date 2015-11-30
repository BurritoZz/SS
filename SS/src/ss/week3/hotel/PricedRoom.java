package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {
	private double prijs;

	public PricedRoom(int no, double rprijs, double sprijs) {
		super(no, "qwerty7", new pricedSafe(sprijs));
		prijs = rprijs;
	}

	@Override
	public double getAmount() {
		return prijs;
	}
	@Override
	public String toString() {
		return "Kamer ter waarde van €" + prijs + " per nacht";
	}

}
