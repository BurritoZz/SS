package ss.week4.math;

public class LinearProduct extends Product	{
	private double c;
	private Function f2;
	public LinearProduct(double c, Function f2) {
		super(new Constant(c), f2);
		this.c = c;
		this.f2 = f2;
	}
	public LinearProduct(Function f2, int c)	{
		super(new Constant(c), f2);
		this.c = c;
		this.f2 = f2;
	}
	@Override
	public double apply(double x) {
		return c * f2.apply(x);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(c, f2.derivative());
	}
}
