package ss.week3.Format;

public class Format {

	public static void main(String[] args) {
		System.out.println(printLine("hallo", 10));
		System.out.println(printLine("hahahahaha", 1000.00000));
		System.out.println(printLine("qbnjmk,ljjajovarjoarvrvjavrojarvajiavinj", -10000000.312123));
	}
	
	public static String printLine(String text, double amount) {
		return String.format("%-80s%,15.2f", text, amount);
	}
	
}
