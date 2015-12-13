package ss.week4.math;

public class Product implements Function {
	protected Function f1;
	protected Function f2;
	public Product(Function f1, Function f2)	{
		this.f1 = f1;
		this.f2 = f2;
	}
	public double apply(double x) {
		return f1.apply(x) * f2.apply(x);
	}

	public Function derivative() {
		return new Sum(new Product(f1.derivative(), f2), new Product(f1, f2.derivative()));
	}
	public String toString()	{
		return f1.toString() + " * " + f2.toString();
	}
}
