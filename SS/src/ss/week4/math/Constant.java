package ss.week4.math;

public class Constant implements Function {
	private double c;
	public Constant(double c)	{
		this.c = c;
	}

	@Override
	public Function derivative() {
		return new Constant(0);
	}
	@Override
	public double apply(double x) {
		return c;
	}
	public String toString()	{
		return "" + c;
	}
}
