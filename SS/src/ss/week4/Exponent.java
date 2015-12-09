package ss.week4;

public class Exponent implements Function {

	public int exp;

	public Exponent(int exp) {
		this.exp = exp;
	}

	public double apply(double d) {
		return Math.pow(d, exp);
	}

	public Function derivative() {
		return new Product(new Constant(exp), new Exponent(exp - 1));
	}

	public String toString() {
		return "f(x) = x^n";
	}

}
