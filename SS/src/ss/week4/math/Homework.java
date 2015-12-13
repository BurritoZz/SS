package ss.week4.math;

public class Homework {
	private static Function f1;
	private static Function f2;
	private static Polynomial f3;
	
	public static void main(String[] args) {
		f1 = new Exponent(8);
		f2 = new LinearProduct(3, f1);
		double[] array = new double[4];
		array[0] = 6;
		array[1] = 7;
		array[2] = -4;
		array[3] = 3.2;
		f3 = new Polynomial(array);
		System.out.println("f(x) = " + f1);
		System.out.println("f(2) = " + f1.apply(2));
		System.out.println("3f(x) = " + f2);
		System.out.println("3f(3) = " + f2.apply(3));
		System.out.println();
		System.out.println("--- Polynomial ---");
		System.out.println("f(x) = " + f3);
		System.out.println("f(0) = " + f3.apply(0));
		System.out.println("f(1) = " + f3.apply(1));
		System.out.println("f(-1) = " + f3.apply(-1));
		System.out.println("f'(x) = " + f3.derivative());
		System.out.println("F(x) = " + f3.integrand());
	}
}