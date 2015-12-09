package ss.week4;

public class Polynomial implements Function {

	public LinearProduct[] products;

	public Polynomial(double[] array) {
		products = new LinearProduct[array.length];
		for (int i = 0; i <= array.length; i++) {
			products[i] = new LinearProduct(new Constant(array[i]), new Exponent(array.length - i));
		}
	}

	public double apply(double d) {
		double sum = 0;
		for (int i = 0; i < products.length / 2; i++) {
			sum += new Sum(products[i], products[products.length - 1 - i]).apply(products[i].apply(d));
		}
		return sum;
	}

	public Function derivative() {
		return null;
	}

}
