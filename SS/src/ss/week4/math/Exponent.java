package ss.week4.math;

public class Exponent implements Function {
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
		return new LinearProduct(n, new Exponent(n - 1));
	}
	public String toString()	{
		return "x^" + n;
	}
}
