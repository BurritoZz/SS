package ss.week4.math;

public class Exponent implements Function, Integrandable {
	private int n;
	
	public Exponent(int n)	{
		this.n = n;
	}

	@Override
	public double apply(double x) {
		return Math.pow(x, n);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Constant(n), new Exponent(n - 1));
	}
	public String toString()	{
		return "x^" + n;
	}

	@Override
	public Function integrand() {
		return new Product(new Constant(1.0 / (n + 1)), new Exponent(n + 1));
	}
}
