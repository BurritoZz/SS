package ss.week3;

public class Format {
	public static void main(String[] args)	{
		System.out.println(printLine("text1", 1));
		System.out.println(printLine("other text", -12.12));
		System.out.println(printLine("something", 0.2));
		System.out.println(printLine("now for somethingcompletely different", 3141519.1504));
	}
	public static String printLine(String text, double amount)	{
		return String.format("%-60s%,12.2f", text, amount);
	}
}