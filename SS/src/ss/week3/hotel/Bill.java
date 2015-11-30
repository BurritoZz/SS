package ss.week3.hotel;
import ss.week3.Format;

public class Bill {
	private java.io.PrintStream output;
	private double sum;
	public Bill(java.io.PrintStream theOutStream)	{
		output = theOutStream;
	}
	public static interface Item	{
		public String toString();
		public double getAmount();
	}
	public void close()	{
		if (output != null)	{
			output.append(Format.printLine("Totaal:", sum));
		}
	}
	public double getSum()	{
		return sum;
	}
	public void newItem(Item item)	{
		if (output != null)	{
			output.append(Format.printLine(item.toString(), item.getAmount()));
		}
		sum = sum + item.getAmount();
	}
}
