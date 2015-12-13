package ss.week4;

public class Polynomial implements Function {

	private LinearProduct[] products;
	private double[] doubles;

	public Polynomial(double[] array) {
		products = new LinearProduct[array.length];
		for (int i = 0; i < array.length; i++) {
			products[i] = new LinearProduct(new Constant(array[i]), new Exponent(array.length - 1 - i));
		}
		doubles = new double[array.length];
		doubles = array;
	}

	public double apply(double d) {
		double sum = 0;
		for (int i = 0; i < products.length / 2; i++) {
			sum += new Sum(products[i], products[products.length - 1 - i]).apply(d);
		}
		return sum;
	}

/*	public Function derivative() {
		derivative = new Function[doubles.length / 2 ];
		Function func = null;
		for (int i = 0; i < doubles.length; i++) {
			if (func == null) {
				func = new Product(new Constant(doubles[i]), new Constant(doubles.length - 1 - i)).derivative();
			}
			else {
				derivative[i / 2] = new Sum(func, new Product(new Constant(doubles[i]), new Constant(doubles.length - 1 - i)).derivative());
				func = null;
			}
		}
		Sum sum = null;
		for (int i = 0; i < derivative.length; i++) {
			sum = new Sum(sum, derivative[i]);
		}
		return sum;
	}*/
	public Function derivative() {
		Function[] derivative = new Function[doubles.length / 2 ];
		Sum sum = new Sum(new Constant(0), new Constant(0));
		for (int i = 0; i < doubles.length - 1; i++) {
			sum = new Sum(sum, new Product(new Constant(doubles[i]), new Constant(doubles.length - 1 - i)).derivative());
		}
		return sum;
	}
	
	public String toString() {
		return "f(x) = an * x^n + an-1 * x^n-1 + ... + a1 * x + a0";
	}
	
}
