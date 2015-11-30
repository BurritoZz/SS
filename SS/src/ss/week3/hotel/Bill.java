package ss.week3.hotel;
import ss.week3.Format;

public class Bill {
	private java.io.PrintStream output;
	public Bill(java.io.PrintStream theOutStream)	{
		output = theOutStream;
	}
	public interface Item	{
		
	}
	public void close()	{
		
	}
	public double getItem()	{
		return 12;
	}
	public void newItem(Bill.Item item)	{
		output.write(Format(item.getDescription(), item.getAmount()));
	}
}
