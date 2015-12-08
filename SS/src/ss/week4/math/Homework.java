package ss.week4.math;

public class Homework {
	private static Function f1;
	private static Function f2;
	
	public static void main(String[] args) {
		f1 = new Exponent(8);
		f2 = new LinearProduct(3, f1);
		System.out.println("f(x) = " + f1);
		System.out.println("f(2) = " + f1.apply(2));
		System.out.println("3f(x) = " + f2);
		System.out.println("3f(3) = " + f2.apply(3));
	}

}
